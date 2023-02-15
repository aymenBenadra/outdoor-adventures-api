package ucode.outdoorshoppingcart;

import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * CartRepository
 */
@Service
public class CartRepository {

  private final RedisTemplate<String, Map<String, Integer>> redisTemplate;
  private final HashOperations<String, String, Integer> hashOps;

  public CartRepository(RedisTemplate<String, Map<String, Integer>> redisTemplate) {
    this.redisTemplate = redisTemplate;
    this.hashOps = redisTemplate.opsForHash();
  }

  public Cart find(String cid) {
    if (!redisTemplate.hasKey(String.valueOf(cid)))
      return null;
    return Cart.builder().cid(cid).items(this.hashOps.entries(cid)).build();
  }

  public List<Cart> findAll() {
    return redisTemplate.keys("cid:*").stream().map(s -> Cart.builder()
        .cid(s)
        .items(hashOps.entries(s))
        .build())
        .toList();
  }

  public Cart save(Cart cart) {
    cart.getItems().forEach((k, v) -> {
      this.hashOps.put(cart.getCid(), k, v);
    });
    return find(cart.getCid());
  }

  public boolean productExists(String cid, String pid) {
    if (!redisTemplate.hasKey(cid))
      return false;
    if (!hashOps.hasKey(cid, pid))
      return false;
    return true;
  }
}
