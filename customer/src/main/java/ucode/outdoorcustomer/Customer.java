package ucode.outdoorcustomer;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Customer
 */
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customer")
public class Customer {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;
}
