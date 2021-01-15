package com.servicenow.app.scheduler;

import com.servicenow.app.entity.Agent;
import com.servicenow.app.entity.Ticket;
import com.servicenow.app.entity.User;
import com.servicenow.app.enums.Role;
import com.servicenow.app.enums.Status;
import com.servicenow.app.respository.AgentRepository;
import com.servicenow.app.respository.TicketRepository;
import com.servicenow.app.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketSchedular {
    @Autowired
    AgentRepository agentRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;
    @Scheduled(fixedRate = 120000)
    public void assignTickets() {
        List<Agent> agents = agentRepository.findAll();
        if(!agents.isEmpty()){
            List<Ticket> tickets = ticketRepository.getUnAssignedTickets();
            int index = 0;
            for(Agent agent: agents){
                if(agent.isAvailable()){
                    if(index >= tickets.size()){
                        break;
                    }
                    Ticket ticket = tickets.get(index);
                    assignTicketAndUpdateAgent(ticket,agent);
                    index++;
                }
            }
        }
    }

    private void assignTicketAndUpdateAgent(Ticket ticket, Agent agent){
        ticket.setAgentId(agent.getId());
        ticket.setStatus(Status.InProgress);
        ticketRepository.save(ticket);
        agent.setAvailable(false);
        agentRepository.save(agent);
        System.out.println("Assigning Ticket");
    }
}
