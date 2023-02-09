package ucode.outdoorcustomer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CustomerRepository
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  public Optional<Customer> findByEmail(String email);
}
