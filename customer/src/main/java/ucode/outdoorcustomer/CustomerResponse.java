package ucode.outdoorcustomer;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * CustomerDto
 */
@Getter
@Setter
@Builder
public class CustomerResponse {
  private Long id;

  @NotNull
  private String username;

  @NotNull
  private String email;
}
