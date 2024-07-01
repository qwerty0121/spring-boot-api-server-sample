package com.example.rest_service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserDto getUserById(long id) {
    return userRepository.getUserById(id);
  }

  @Transactional
  public long createUser(UserDto user) {
    long userId = userRepository.createUser(user);
    if ("error".equals(user.getName())) {
      throw new RuntimeException("予期せぬエラー");
    }
    return userId;
  }

}
