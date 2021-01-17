package com.myservice.app.service;

import com.myservice.app.DTO.AgentDto;
import com.myservice.app.entity.Agent;

public interface AgentService {
    Agent createAgent(AgentDto agentDto);
}
