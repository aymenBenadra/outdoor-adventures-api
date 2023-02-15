package ucode.outdoorshoppingcart.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {
    return new JedisConnectionFactory();
  }

  @Bean
  public RedisTemplate<String, Map<String, Integer>> redisTemplate(
      RedisConnectionFactory redisConnectionFactory) {
    var template = new RedisTemplate<String, Map<String, Integer>>();
    template.setConnectionFactory(redisConnectionFactory);
    return template;
  }
}
