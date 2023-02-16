package ucode.outdoorshoppingcart;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ucode.outdoorshoppingcart.util.KeyUtils;

/**
 * CartRepositoryTests
 */
@SpringBootTest
public class CartRepositoryTests {

  @Autowired
  private CartRepository cartRepository;

  @Test
  void shouldCheckForExistingCart() {
    // given
    var cart = Cart.builder().cid(KeyUtils.cid(12L)).items(new HashMap<>()).build();
    cartRepository.save(cart);

    // when
    var isFound = cartRepository.cartExists(KeyUtils.cid(12L));

    // then
    assertTrue(isFound);
  }

  @Test
  void shouldCheckForNotExistingCart() {
    // given
    var cid = KeyUtils.cid(12L);

    // when
    var isFound = cartRepository.cartExists(cid);

    // then
    assertTrue(isFound);
  }
}
