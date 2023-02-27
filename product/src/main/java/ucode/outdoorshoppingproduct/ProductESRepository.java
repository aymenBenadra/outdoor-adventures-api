package ucode.outdoorshoppingproduct;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * ProductRepository
 */
public interface ProductESRepository extends ElasticsearchRepository<Product, String> {
  List<Product> findByPriceBetween(int minPrice, int maxPrice);
}
