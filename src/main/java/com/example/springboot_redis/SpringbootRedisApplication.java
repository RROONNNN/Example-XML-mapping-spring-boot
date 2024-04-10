package com.example.springboot_redis;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.springboot_redis.Service.UserService;


@SpringBootApplication()

public class SpringbootRedisApplication {
	 @Bean
	  public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
	    RedisTemplate<?, ?> template = new RedisTemplate<>();
	    template.setConnectionFactory(connectionFactory);

	    return template;
	  }

	  @Bean
	  public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }

	  public static void main(String[] args) {
	    SpringApplication.run(SpringbootRedisApplication.class, args);
	    
	    
	  }


}
