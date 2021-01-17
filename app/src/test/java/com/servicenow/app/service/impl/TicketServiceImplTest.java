package com.servicenow.app.service.impl;

import com.servicenow.app.DTO.TicketRequestDto;
import com.servicenow.app.entity.Ticket;
import com.servicenow.app.respository.AgentRepository;
import com.servicenow.app.respository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TicketServiceImpl.class)
public class TicketServiceImplTest {

    TicketServiceImpl ticketService = new TicketServiceImpl();
    TicketRepository ticketRepository;
    AgentRepository agentRepository;

    @Test
    public void getAllTickets() {
        ticketRepository = mock(TicketRepository.class);
        agentRepository = mock(AgentRepository.class);
        ticketService.setAgentRepository(agentRepository);
        ticketService.setTicketRepository(ticketRepository);
        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket = new Ticket();
        tickets.add(ticket);
        when(ticketRepository.findAll()).thenReturn(tickets);
        assertEquals(ticketService.getAllTickets().size(), 1);
    }

    @Test
    public void createTicket() {
    }

    @Test
    void getTicket() {
    }

    @Test
    void getTickets() {
    }

    @Test
    void closeTicket() {
    }

    @Test
    void sendFeedBack() {
    }

    @Test
    void resolveTicket() {
    }
}