package ucode.outdoorshoppingproduct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ucode.outdoorshoppingproduct.util.ProductNotFoundException;

/**
 * ProductService
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

  private final ProductESRepository productRepository;
  private final ElasticsearchOperations elasticsearchOperations;

  public List<Product> getAllProducts() {
    List<Product> products = new ArrayList<>();
    productRepository.findAll().forEach(products::add);
    return products;
  }

  public String createProduct(Product product) {
    return elasticsearchOperations.save(product).getId();
  }

  public void logProduct(Product product) {
    log.info(product.toString());
  }

  public Product getProduct(String id) {
    return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
  }

  public void updateProduct(String id, ProductRequest product) {
    productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    var p = Product.builder()
        .id(id).name(product.name())
        .description(product.description())
        .keywords(product.keywords()).build();
    productRepository.save(p);
  }

  public void deleteProduct(String id) {
    productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    productRepository.deleteById(id);
  }

}
