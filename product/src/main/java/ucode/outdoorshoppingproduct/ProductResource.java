package ucode.outdoorshoppingproduct;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * ProductResource
 */
@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductResource {

  private final ProductService productService;

  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts() {
    return ResponseEntity.ok(productService.getAllProducts());
  }

  @PostMapping
  public ResponseEntity<String> createProduct(@RequestBody Product product) {
    return ResponseEntity.ok(productService.createProduct(product));
  }

  @PostMapping("/test")
  public ResponseEntity<Void> logProduct(@RequestBody Product product) {
    productService.logProduct(product);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable("id") String id) {
    return ResponseEntity.ok(productService.getProduct(id));
  }
}
