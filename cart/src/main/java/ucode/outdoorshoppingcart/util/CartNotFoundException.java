package ucode.outdoorshoppingcart.util;

/**
 * CartException
 */
public class CartNotFoundException extends RuntimeException {
  public CartNotFoundException(String msg) {
    super(msg);
  }
}
