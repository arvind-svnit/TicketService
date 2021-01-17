package com.myservice.app.service;

import com.myservice.app.DTO.UserRequestDto;
import com.myservice.app.entity.User;

import java.util.List;

public interface UserService {
    User createUser(UserRequestDto userRequestDto);
    List<User> getAllUser();
}
