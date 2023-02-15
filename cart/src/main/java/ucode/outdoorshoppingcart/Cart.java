package ucode.outdoorshoppingcart;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

/**
 * Cart
 */
@Data
@Builder
public class Cart {

  private String cid;
  private Map<String, Integer> items;
}
