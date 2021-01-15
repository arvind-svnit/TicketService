package com.servicenow.app.respository;

import com.servicenow.app.entity.Agent;
import com.servicenow.app.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}
