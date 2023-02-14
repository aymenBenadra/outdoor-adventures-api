package ucode.outdoorshoppingcart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {

  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {
    return new JedisConnectionFactory();
  }

  @Bean
  public StringRedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    var template = new StringRedisTemplate();
    template.setConnectionFactory(redisConnectionFactory);
    return template;
  }
}
