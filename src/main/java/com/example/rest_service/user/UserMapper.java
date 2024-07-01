package com.example.rest_service.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("select * from users where id = #{id}")
  UserDto getUserById(long id);

  @Insert("insert into users(name, address) values (#{name}, #{address})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  long createUser(UserDto user);

}
