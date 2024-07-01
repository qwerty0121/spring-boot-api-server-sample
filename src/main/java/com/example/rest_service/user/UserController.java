package com.example.rest_service.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users/{id}")
  public User getUserById(@PathVariable long id) {
    UserDto userDto = userService.getUserById(id);
    return new User(userDto.getId(), userDto.getName(), userDto.getAddress());
  }

  @PostMapping("/users")
  public long createUser(@RequestBody User user) {
    UserDto userDto = new UserDto();
    userDto.setName(user.name());
    userDto.setAddress(user.address());

    return userService.createUser(userDto);
  }

}
