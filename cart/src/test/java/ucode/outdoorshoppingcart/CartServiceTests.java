package ucode.outdoorshoppingcart;

import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * CartServiceTests
 */
@SpringBootTest
public class CartServiceTests {

  @Autowired
  private RedisTemplate<String, Map<String, Integer>> redisTemplate;

  @Mock
  private CartRepository cartRepository;
  private CartService cartService;
  private AutoCloseable autoCloseable;

  @BeforeEach
  void setUp() {
    autoCloseable = MockitoAnnotations.openMocks(this);
    cartService = new CartService(redisTemplate, cartRepository);
  }

  @AfterEach
  void tearDown() throws Exception {
    autoCloseable.close();
  }

  @Test
  void shouldGetAllCarts() {
    // when
    cartService.getAllCarts();

    // then
    Mockito.verify(cartRepository).findAll();
  }
}
