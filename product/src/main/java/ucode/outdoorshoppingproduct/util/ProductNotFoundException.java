package ucode.outdoorshoppingproduct.util;

/**
 * ProductNotFoundException
 */
public class ProductNotFoundException extends RuntimeException {

  public ProductNotFoundException(String id) {
    super("product with id: " + id + " not found!.");
  }
}
