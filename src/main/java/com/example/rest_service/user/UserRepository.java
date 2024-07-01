package com.example.rest_service.user;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  private final UserMapper userMapper;

  public UserRepository(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  public UserDto getUserById(long id) {
    return userMapper.getUserById(id);
  }

  public long createUser(UserDto user) {
    userMapper.createUser(user);
    return user.getId();
  }

}
