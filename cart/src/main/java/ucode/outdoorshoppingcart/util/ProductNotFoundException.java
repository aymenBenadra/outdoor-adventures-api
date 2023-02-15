package ucode.outdoorshoppingcart.util;

/**
 * ProductNotFoundException
 */
public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(long cid, long pid) {
    super("product with id " + pid + " not found in cart with id " + cid);
  }
}
