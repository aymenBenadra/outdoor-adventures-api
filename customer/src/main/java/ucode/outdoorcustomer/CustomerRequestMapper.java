package ucode.outdoorcustomer;

import java.util.function.Function;

import org.springframework.stereotype.Component;

/**
 * CustomerMapper
 */
@Component
public class CustomerRequestMapper implements Function<CustomerRequest, Customer> {

  @Override
  public Customer apply(CustomerRequest t) {
    var c = new Customer();
    c.setUsername(t.username());
    c.setEmail(t.email());
    c.setPassword(t.password());
    return c;
  }

}
