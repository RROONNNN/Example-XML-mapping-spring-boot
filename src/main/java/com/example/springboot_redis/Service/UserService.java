package com.example.springboot_redis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_redis.Models.User;
import com.example.springboot_redis.repositories.UserRepository;

@Service
public class UserService implements I_UserService{
UserRepository userRepository;
public UserService() {
	// TODO Auto-generated constructor stub
}
@Autowired	
public UserService(UserRepository userRepository) {
	super();
	this.userRepository = userRepository;
}
	@Override
public long count() {
	
	return userRepository.count();
}
@Override
	public void save(User user) {
		userRepository.save(user);
		
	}
}
