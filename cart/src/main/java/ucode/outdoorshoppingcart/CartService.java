package ucode.outdoorshoppingcart;

import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * CartService
 */
@Slf4j
@Service
public class CartService {

  private final RedisTemplate<String, Map<String, Integer>> redisTemplate;
  private final HashOperations<String, String, Integer> hashOps;
  private final RedisAtomicLong cartIdCounter;
  private final CartRepository cartRepository;

  public CartService(RedisTemplate<String, Map<String, Integer>> redisTemplate, CartRepository cartRepository) {
    this.redisTemplate = redisTemplate;
    this.cartIdCounter = new RedisAtomicLong("globla:cid", redisTemplate.getConnectionFactory());
    this.hashOps = redisTemplate.opsForHash();
    this.cartRepository = cartRepository;
  }

  public Long createCart() {
    long cid = cartIdCounter.incrementAndGet();
    log.info("new cart id: " + cid);
    hashOps.put("cid:" + cid, "null", 0);
    return cid;
  }

  public Cart getCartItems(String cid) {
    return Cart.builder().cid(cid).items(hashOps.entries(cid)).build();
  }

  public void addToCart(String cid, String pid, int quantity) {
    if (!redisTemplate.hasKey(cid)) {
      log.warn("cart with id " + cid + " not found");
      return;
    }
    hashOps.put(cid, pid, quantity);
  }

  public List<Cart> getAllCarts() {
    return cartRepository.findAll();
  }
}
