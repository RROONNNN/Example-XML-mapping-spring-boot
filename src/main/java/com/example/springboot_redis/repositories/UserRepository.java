package com.example.springboot_redis.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot_redis.Models.User;

public interface UserRepository extends CrudRepository<User, String>{

}
