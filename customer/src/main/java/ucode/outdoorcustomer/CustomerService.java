package ucode.outdoorcustomer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ucode.outdoorcustomer.util.CustomerException;

/**
 * CustomerService
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final CustomerResponseMapper customerResponseMapper;
  private final CustomerRequestMapper customerRequestMapper;

  public Long createCustomer(CustomerRequest customer) {
    log.info("creating customer with email: " + customer.email());
    return customerRepository.save(customerRequestMapper.apply(customer)).getId();
  }

  public List<CustomerResponse> getAllCustomers() {
    return customerRepository.findAll().stream().map(customerResponseMapper).collect(Collectors.toList());
  }

  public CustomerResponse getCustomer(Long customerId) {
    return customerResponseMapper.apply(customerRepository.findById(customerId)
        .orElseThrow(() -> new CustomerException("customer with id: " + customerId + " not found")));
  }

  public void updateCustomer(Long customerId, CustomerRequest customer) {
    log.info("updating customer with id: " + customerId);
    var c = customerRepository.findById(customerId)
        .orElseThrow(() -> new CustomerException("customer with id: " + customerId + " not found"));
    c.setEmail(customer.email());
    c.setUsername(customer.username());
    customerRepository.save(c);
  }
}
