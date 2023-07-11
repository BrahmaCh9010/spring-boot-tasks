package com.jwtAuthentication.service;

import java.util.List;

import com.jwtAuthentication.model.User;
import com.jwtAuthentication.model.UserDto;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(int id);

    User findOne(String username);

    User findById(int id);

    UserDto update(UserDto userDto);
}
