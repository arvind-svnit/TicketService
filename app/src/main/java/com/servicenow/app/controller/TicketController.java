package com.servicenow.app.controller;

import com.servicenow.app.DTO.TicketRequestDto;
import com.servicenow.app.entity.Ticket;
import com.servicenow.app.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping()
    public List<Ticket> getAllTickets(@RequestParam(name = "userId", required = false) Long userId){
        if(userId != null){
            return ticketService.getTickets(userId);
        }
        return ticketService.getAllTickets();
    }

    @GetMapping("{id}")
    public Optional<Ticket> getTicket(@PathVariable(value = "id") Long id){
        return ticketService.getTicket(id);
    }

    @PostMapping()
    public Ticket createTicket(@RequestBody TicketRequestDto ticketRequestDto){
        return ticketService.createTicket(ticketRequestDto);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public Ticket resolveTicket(@PathVariable(value = "id") Long id, @RequestBody String response){
        return ticketService.resolveTicket(id, response);
    }

    @PutMapping("{id}")
    public Ticket closeTicket(@PathVariable(value = "id") Long id){
        return ticketService.closeTicket(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Ticket sendFeedBack(@PathVariable(value = "id") Long id, @RequestBody String feedBack){
        return ticketService.sendFeedBack(id, feedBack);
    }

}
