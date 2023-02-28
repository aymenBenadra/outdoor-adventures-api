package ucode.outdoorshoppingproduct;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable("id") String id) {
    return ResponseEntity.ok(productService.getProduct(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateProduct(@PathVariable("id") String id, @RequestBody ProductRequest product) {
    productService.updateProduct(id, product);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable("id") String id) {
    productService.deleteProduct(id);
    return ResponseEntity.ok().build();
  }

}
