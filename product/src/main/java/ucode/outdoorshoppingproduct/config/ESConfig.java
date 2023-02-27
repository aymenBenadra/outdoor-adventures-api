package ucode.outdoorshoppingproduct.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

/**
 * ESConfig
 */
@Configuration
public class ESConfig extends ElasticsearchConfiguration {

  @Value("${spring.es.host}")
  private String esHost;

  @Value("${spring.es.port}")
  private String esPort;

  @Override
  public ClientConfiguration clientConfiguration() {
    return ClientConfiguration.builder()
        .connectedTo(esHost + ":" + esPort)
        .build();
  }

}
