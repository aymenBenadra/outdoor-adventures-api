package ucode.outdoorshoppingcart;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * CartService
 */
@Slf4j
@Service
public class CartService {

  private final StringRedisTemplate redisTemplate;
  private final ListOperations<String, String> listOps;
  private final RedisAtomicLong cartIdCounter;

  public CartService(StringRedisTemplate redisTemplate) {
    this.redisTemplate = redisTemplate;
    this.listOps = redisTemplate.opsForList();
    this.cartIdCounter = new RedisAtomicLong("globla:cid", redisTemplate.getConnectionFactory());
  }

  public Long createCart() {
    long cid = cartIdCounter.incrementAndGet();
    log.info("new cart id: " + cid);
    listOps.leftPush("cid:" + cid, "null");
    return cid;
  }

  public Cart getCartItems(Long cid) {
    return Cart.builder().cid(cid).items(listOps.range("cid:" + cid, 0, -1)).build();
  }
}
