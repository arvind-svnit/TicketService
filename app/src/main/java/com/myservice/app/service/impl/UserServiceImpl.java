package com.myservice.app.service.impl;

import com.myservice.app.DTO.AgentDto;
import com.myservice.app.DTO.UserRequestDto;
import com.myservice.app.entity.User;
import com.myservice.app.enums.Role;
import com.myservice.app.respository.UserRepository;
import com.myservice.app.service.AgentService;
import com.myservice.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AgentService agentService;

    @Override
    public User createUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setEmail(userRequestDto.getEmail());
        user.setRole(userRequestDto.getRole());
        userRepository.save(user);
        if(user.getRole().equals(Role.Agent)){
            createAgent(user);
        }
        return user;
    }

    private void createAgent(User user) {
        AgentDto agentDto = new AgentDto();
        agentDto.setUserId(user.getId());
        agentService.createAgent(agentDto);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
