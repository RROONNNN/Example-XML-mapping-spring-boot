package com.example.springboot_redis.Models;

import java.util.HashSet;
import java.util.Set;





import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.annotation.Transient;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonIgnoreProperties(value =  { "password", "passwordConfirm" }, allowSetters = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Data
@RedisHash
public class User {

  @Id
  @ToString.Include
  private String id;

  @NotNull
  @Size(min = 2, max = 48)
  @ToString.Include
  private String name;

  @NotNull
  @Email
  @EqualsAndHashCode.Include
  @ToString.Include
  @Indexed
  private String email;

  @NotNull
  private String password;

  @Transient
  private String passwordConfirm;

  @Reference
  private Set<Role> roles = new HashSet<Role>();

  public void addRole(Role role) {
    roles.add(role);
  }
}