package ucode.outdoorshoppingproduct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ProductService
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

  private final ProductESRepository productRepository;

  public List<Product> getAllProducts() {
    List<Product> products = new ArrayList<>();
    productRepository.findAll().forEach(products::add);
    return products;
  }

  public String createProduct(Product product) {
    return productRepository.save(product).getId();
  }

  public void logProduct(Product product) {
    log.info(product.toString());
  }

  public Product getProduct(String id) {
    return productRepository.findById(id).orElseThrow();
  }

}
