package com.example.springboot_redis.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Data;
import lombok.Builder;
@Builder
@Data	
@RedisHash
public class Role {
	@Id
private String id;

	  @Indexed
private String name;




}
