package ucode.outdoorcustomer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * CustomerService
 */
@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final CustomerResponseMapper customerResponseMapper;
  private final CustomerRequestMapper customerRequestMapper;

  public Long createCustomer(CustomerRequest customer) {
    return customerRepository.save(customerRequestMapper.apply(customer)).getId();
  }

  public List<CustomerResponse> getAllCustomers() {
    return customerRepository.findAll().stream().map(customerResponseMapper).collect(Collectors.toList());
  }

  public CustomerResponse getCustomer(Long customerId) {
    return customerResponseMapper.apply(customerRepository.findById(customerId).orElseThrow());
  }

  public void updateCustomer(Long customerId, CustomerRequest customer) {
    var c = customerRepository.findById(customerId).orElseThrow();
    c.setEmail(customer.email());
    c.setUsername(customer.username());
    customerRepository.save(c);
  }
}
