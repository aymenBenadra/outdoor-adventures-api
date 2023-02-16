package ucode.outdoorshoppingcart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ucode.outdoorshoppingcart.util.CartNotFoundException;
import ucode.outdoorshoppingcart.util.KeyUtils;
import ucode.outdoorshoppingcart.util.ProductNotFoundException;

/**
 * CartService
 */
@Slf4j
@Service
public class CartService {

  private final HashOperations<String, String, Integer> hashOps;
  private final RedisAtomicLong cartIdCounter;
  private final CartRepository cartRepository;

  public CartService(RedisTemplate<String, Map<String, Integer>> redisTemplate, CartRepository cartRepository) {
    this.cartIdCounter = new RedisAtomicLong(KeyUtils.globalCid(), redisTemplate.getConnectionFactory());
    this.hashOps = redisTemplate.opsForHash();
    this.cartRepository = cartRepository;
  }

  public Long createCart() {
    long cid = cartIdCounter.incrementAndGet();
    var cart = Cart.builder().cid(KeyUtils.cid(cid)).items(new HashMap<>()).build();
    cartRepository.save(cart);
    return cid;
  }

  public Cart getCartItems(long cid) {
    return Optional.ofNullable(cartRepository.find(KeyUtils.cid(cid)))
        .orElseThrow(() -> new CartNotFoundException(cid));
  }

  public void addToCart(long cid, long pid, int quantity) {
    if (cartRepository.cartExists(KeyUtils.cid(cid))) {
      log.warn("cart with id " + cid + " not found");
      throw new CartNotFoundException(cid);
    }
    hashOps.put(KeyUtils.cid(cid), KeyUtils.pid(pid), quantity);
  }

  public List<Cart> getAllCarts() {
    return cartRepository.findAll();
  }

  public void deleteFromCart(long cid, long pid) {
    Optional.ofNullable(cartRepository.find(KeyUtils.cid(cid)))
        .orElseThrow(() -> new CartNotFoundException(cid));
    if (!cartRepository.productExists(KeyUtils.cid(cid), KeyUtils.pid(pid)))
      throw new ProductNotFoundException(cid, pid);
    hashOps.delete(KeyUtils.cid(cid), KeyUtils.pid(pid));
  }
}
