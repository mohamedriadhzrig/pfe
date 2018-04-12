package com.sopra.Iservice;

import java.util.List;

import com.sopra.entities.User;
import com.sopra.entities.UserRequest;


public interface UserService {
  void resetCredentials();

  User findById(Long id);

  User findByUsername(String username);

  List<User> findAll();

  User save(UserRequest user);
}
