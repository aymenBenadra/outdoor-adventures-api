package ucode.outdoorshoppingcart;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * CartResource
 */
@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartResource {
  private final CartService cartService;

  @GetMapping
  public Long createCart() {
    return cartService.createCart();
  }

  @GetMapping(value = "/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Cart getCartitems(@PathVariable Long cid) {
    return cartService.getCartItems(cid);
  }
}
