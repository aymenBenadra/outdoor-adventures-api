package ucode.outdoorcustomer;

import java.util.function.Function;

import org.springframework.stereotype.Component;

/**
 * CustomerDtoMapper
 */
@Component
public class CustomerResponseMapper implements Function<Customer, CustomerResponse> {

  @Override
  public CustomerResponse apply(Customer t) {
    return CustomerResponse.builder()
        .id(t.getId())
        .username(t.getUsername())
        .email(t.getEmail())
        .build();
  }

}
