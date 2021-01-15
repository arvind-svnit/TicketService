package com.servicenow.app.service;

import com.servicenow.app.DTO.UserRequestDto;
import com.servicenow.app.entity.User;

import java.util.List;

public interface UserService {
    User createUser(UserRequestDto userRequestDto);
    List<User> getAllUser();
}
