package com.myservice.app.service;

import com.myservice.app.DTO.TicketRequestDto;
import com.myservice.app.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
     List<Ticket> getAllTickets();
     Ticket createTicket(TicketRequestDto ticketRequestDto);
     Optional<Ticket> getTicket(Long id);
     List<Ticket> getTickets(Long userId);
     Ticket closeTicket(Long id);
     Ticket resolveTicket(Long id, String response);
     Ticket sendFeedBack(Long id, String feedBack);
}
