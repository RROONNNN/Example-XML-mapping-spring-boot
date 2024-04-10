package com.example.springboot_redis.boot;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.example.springboot_redis.Models.Role;
import com.example.springboot_redis.Models.User;
import com.example.springboot_redis.Service.UserService;
import com.example.springboot_redis.repositories.RoleRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Component
@Order(2)
@Slf4j
public class CreateUsers implements CommandLineRunner {


	  private RoleRepository roleRepository;
	
	  private UserService userService;

	  private BCryptPasswordEncoder passwordEncoder;

	 public CreateUsers() {
		
	}




@Autowired
public CreateUsers(RoleRepository roleRepository, UserService userService, BCryptPasswordEncoder passwordEncoder) {
		super();
		this.roleRepository = roleRepository;
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}





@Override
  public void run(String... args) throws Exception {
	if (userService==null) System.out.println("nguuuuuuuuuu");
	else {
		  System.out.println("Here is CreateUsers");
	  if (userService.count() == 0) {
	      // load the roles
		 Role admin = roleRepository.findFirstByName("admin");
		  System.out.println("Here is CreateUsers :" + admin.getName());
	      Role customer = roleRepository.findFirstByName("customer");
		  System.out.println("Here is CreateUsers :" + customer.getName());
	      

	      try {
	    	
		        // create a Jackson object mapper
		        ObjectMapper mapper = new ObjectMapper();
		        // create a type definition to convert the array of JSON into a List of Users
		        TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {};
		        // make the JSON data available as an input stream
		        InputStream inputStream = typeReference.getClass().getResourceAsStream("/data/users/users.json");
		        // convert the JSON to objects
		        List<User> users = mapper.readValue(inputStream, typeReference);

		        users.stream().forEach((user) -> {
		        	if(user!=null) {
		        	    user.setPassword(passwordEncoder.encode(user.getPassword()));
		  	        user.addRole(customer);
		  	        userService.save(user);
		        	}
		      
		        });
		        
		        log.info(">>>> " + users.size()+ " Users Saved!"  );
		        
		      } catch (IOException e) {
		        log.info(">>>> Unable to import users: " + e.getMessage());
		      }
		      User adminUser = new User();
		      adminUser.setName("Adminus Admistradore");
		      adminUser.setEmail("admin@example.com");
		      adminUser.setPassword(passwordEncoder.encode("Reindeer Flotilla"));//
		   adminUser.addRole(admin);
		      userService.save(adminUser);
	      log.info(">>>> Loaded User Data and Created users...");}
    
  }

}

}
