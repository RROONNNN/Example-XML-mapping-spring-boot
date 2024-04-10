package com.example.springboot_redis.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.springboot_redis.Models.Role;
import com.example.springboot_redis.repositories.RoleRepository;

import lombok.extern.slf4j.Slf4j;
@Component
@Order(1)
@Slf4j
public class CreateRoles implements CommandLineRunner{
@Autowired
	private	RoleRepository roleRepository;
@Override
public void run(String... args) throws Exception {
	 System.out.println("Here is CreateRoles");
	   if (roleRepository.count() == 0) {
		   
		      Role adminRole = Role.builder().name("admin").build();
		      Role customerRole = Role.builder().name("customer").build();
		      roleRepository.save(adminRole);
		      roleRepository.save(customerRole);
		    //  Role role=roleRepository.findFirstByName("admin");
		      log.info(">>>> Created admin and customer roles...");
		    }
	
}
}
