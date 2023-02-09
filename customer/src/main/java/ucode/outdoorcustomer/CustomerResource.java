package ucode.outdoorcustomer;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * CustomerResource
 */
@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerResource {

  private final CustomerService customerService;

  @GetMapping
  public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
    return ResponseEntity.ok(customerService.getAllCustomers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("id") Long customerId) {
    return ResponseEntity.ok(customerService.getCustomer(customerId));
  }

  @PostMapping
  public ResponseEntity<Long> createCustomer(@RequestBody @Valid CustomerRequest customer) {
    return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateCustomer(@PathVariable("id") Long customerId,
      @RequestBody CustomerRequest customer) {
    customerService.updateCustomer(customerId, customer);
    return ResponseEntity.noContent().build();
  }

}
