package com.servicenow.app.service;

import com.servicenow.app.DTO.AgentDto;
import com.servicenow.app.entity.Agent;

public interface AgentService {
    Agent createAgent(AgentDto agentDto);
}
