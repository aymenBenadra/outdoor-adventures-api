package ucode.outdoorshoppingcart;

import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * Cart
 */
@Data
@Builder
public class Cart {

  private Long cid;
  private List<String> items;
}
