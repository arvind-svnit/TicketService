package com.servicenow.app.service.impl;

import com.servicenow.app.DTO.AgentDto;
import com.servicenow.app.DTO.UserRequestDto;
import com.servicenow.app.entity.Agent;
import com.servicenow.app.entity.User;
import com.servicenow.app.enums.Role;
import com.servicenow.app.respository.AgentRepository;
import com.servicenow.app.respository.UserRepository;
import com.servicenow.app.service.AgentService;
import com.servicenow.app.service.UserService;
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
