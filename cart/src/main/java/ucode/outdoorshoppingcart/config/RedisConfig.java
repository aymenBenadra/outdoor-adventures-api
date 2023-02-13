package ucode.outdoorshoppingcart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {
  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {
      var config = new RedisStandaloneConfiguration("localhost", 6379);
    return new JedisConnectionFactory(config);
  }

  @Bean
  public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
    var template = new StringRedisTemplate(redisConnectionFactory);
    return template;
  }
}
