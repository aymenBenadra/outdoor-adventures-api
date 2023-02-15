package ucode.outdoorshoppingcart;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public Cart getCartitems(@PathVariable long cid) {
    return cartService.getCartItems(cid);
  }

  @PostMapping("/{id}")
  public ResponseEntity<?> addToCart(@PathVariable("id") Long cid, @RequestBody AddToCartRequest addToCartRequest) {
    cartService.addToCart(cid, addToCartRequest.pid(), addToCartRequest.quantity());
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/all")
  public ResponseEntity<List<Cart>> getAllCarts() {
    return ResponseEntity.ok(cartService.getAllCarts());
  }

  @DeleteMapping("/{cid}/{pid}")
  public ResponseEntity<Void> deleteFromCart(@PathVariable("cid") long cid, @PathVariable("pid") long pid) {
    cartService.deleteFromCart(cid, pid);
    return ResponseEntity.noContent().build();
  }
}

record AddToCartRequest(long pid, int quantity) {
}
