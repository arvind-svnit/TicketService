package com.servicenow.app.service.impl;

import com.servicenow.app.DTO.AgentDto;
import com.servicenow.app.entity.Agent;
import com.servicenow.app.respository.AgentRepository;
import com.servicenow.app.service.AgentService;
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
