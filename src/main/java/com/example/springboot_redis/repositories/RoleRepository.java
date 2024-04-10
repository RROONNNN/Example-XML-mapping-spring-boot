package com.example.springboot_redis.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot_redis.Models.Role;
@Repository
public interface RoleRepository extends CrudRepository<Role,String>{
	  Role findFirstByName(String role);
}
