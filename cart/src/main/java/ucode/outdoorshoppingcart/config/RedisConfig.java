package ucode.outdoorshoppingcart.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

  @Value("${spring.redis.host}")
  private String redisHost;

  @Value("${spring.redis.port}")
  private int redisPort;

  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {
    var config = new RedisStandaloneConfiguration(redisHost, redisPort);
    return new JedisConnectionFactory(config);
  }

  @Bean
  public RedisTemplate<String, Map<String, Integer>> redisTemplate(
      RedisConnectionFactory redisConnectionFactory) {
    var template = new RedisTemplate<String, Map<String, Integer>>();
    template.setConnectionFactory(redisConnectionFactory);
    return template;
  }
}
