package ucode.outdoorshoppingcart.util;

/**
 * CartException
 */
public class CartNotFoundException extends RuntimeException {
  public CartNotFoundException(long cid) {
    super("cart with id: " + cid + " not found");
  }
}
