package com.servicenow.app.service.impl;

import com.servicenow.app.DTO.TicketRequestDto;
import com.servicenow.app.DTO.TicketUpdateDto;
import com.servicenow.app.entity.Agent;
import com.servicenow.app.entity.Ticket;
import com.servicenow.app.enums.Status;
import com.servicenow.app.respository.AgentRepository;
import com.servicenow.app.respository.TicketRepository;
import com.servicenow.app.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket createTicket(TicketRequestDto ticketRequestDto) {
        Ticket ticket = new Ticket();
        ticket.setDeviceId(ticketRequestDto.getDeviceId());
        ticket.setDescription(ticketRequestDto.getDescription());
        ticket.setSeverity(ticketRequestDto.getSeverity());
        ticket.setStatus(Status.Open);
        ticket.setUserId(ticketRequestDto.getUserId());
        return ticketRepository.save(ticket);
    }

    @Override
    public Optional<Ticket> getTicket(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public List<Ticket> getTickets(Long userId) {
        return ticketRepository.getTicketsByUserId(userId);
    }

    @Override
    public Ticket closeTicket(Long id) {
        Ticket ticket = ticketRepository.getOne(id);
        ticket.setStatus(Status.Close);
        Agent agent = agentRepository.getOne(ticket.getUserId());
        agent.setAvailable(true);
        agentRepository.save(agent);
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket sendFeedBack(Long id, String feedBack) {
        Ticket ticket = ticketRepository.getOne(id);
        StringBuffer feedBackBuffer = new StringBuffer();
        feedBackBuffer.append(ticket.getFeedBack()+"\n"+feedBack);
        ticket.setFeedBack(feedBackBuffer.toString());
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket resolveTicket(Long id, String response) {
        Ticket ticket = ticketRepository.getOne(id);
        StringBuffer responseBuffer = new StringBuffer();
        responseBuffer.append(ticket.getResponse()+"\n");
        responseBuffer.append(" Agent "+ticket.getAgentId()+" ");
        responseBuffer.append(response+"\n");
        ticket.setResponse(responseBuffer.toString());
        return ticketRepository.save(ticket);
    }

    public void setTicketRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void setAgentRepository(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }
}
