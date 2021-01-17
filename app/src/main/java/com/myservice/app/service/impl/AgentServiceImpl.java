package com.myservice.app.service.impl;

import com.myservice.app.DTO.AgentDto;
import com.myservice.app.entity.Agent;
import com.myservice.app.respository.AgentRepository;
import com.myservice.app.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    AgentRepository agentRepository;
    @Override
    public Agent createAgent(AgentDto agentDto) {
        Agent agent = new Agent();
        agent.setUserId(agentDto.getUserId());
        agent.setAvailable(true);
        agentRepository.save(agent);
        return agent;
    }
}
