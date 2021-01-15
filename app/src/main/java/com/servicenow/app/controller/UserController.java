package com.servicenow.app.controller;

import com.servicenow.app.DTO.UserDto;
import com.servicenow.app.DTO.UserRequestDto;
import com.servicenow.app.entity.User;
import com.servicenow.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @PostMapping
    public User createUser(@RequestBody UserRequestDto userRequestDto){
        return userService.createUser(userRequestDto);
    }
}
