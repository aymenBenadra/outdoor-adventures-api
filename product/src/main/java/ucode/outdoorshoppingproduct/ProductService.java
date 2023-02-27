package ucode.outdoorshoppingproduct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * ProductService
 */
@Service
@RequiredArgsConstructor
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

}
