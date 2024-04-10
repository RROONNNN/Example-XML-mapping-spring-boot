package com.example.springboot_redis.Service;

import com.example.springboot_redis.Models.User;

public interface I_UserService  {
long count();
void save(User user);
}
