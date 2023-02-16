package ucode.outdoorshoppingcart;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * CartServiceTests
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CartServiceTests {

  @Autowired
  private RedisTemplate<String, Map<String, Integer>> redisTemplate;

  @Mock
  private CartRepository cartRepository;
  private CartService cartService;

  @BeforeEach
  void setUp() {
    cartService = new CartService(redisTemplate, cartRepository);
  }

  @Test
  void shouldGetAllCarts() {
    // when
    cartService.getAllCarts();

    // then
    Mockito.verify(cartRepository).findAll();
  }
}
