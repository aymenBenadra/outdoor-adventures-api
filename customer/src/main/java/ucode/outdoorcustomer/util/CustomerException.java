package ucode.outdoorcustomer.util;

/**
 * CustomerNotFoundException
 */
public class CustomerException extends RuntimeException {
  public CustomerException(String msg) {
    super(msg);
  }

  public CustomerException() {
    super();
  }

}
