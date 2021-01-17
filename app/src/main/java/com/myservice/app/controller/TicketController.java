package com.myservice.app.controller;

import com.myservice.app.DTO.TicketRequestDto;
import com.myservice.app.entity.Ticket;
import com.myservice.app.service.TicketService;
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

    @RequestMapping(value = "{id}/resolveTicket", method = RequestMethod.POST)
    public Ticket resolveTicket(@PathVariable(value = "id") Long id, @RequestBody String comment){
        return ticketService.resolveTicket(id, comment);
    }

    @PutMapping("{id}")
    public Ticket closeTicket(@PathVariable(value = "id") Long id){
        return ticketService.closeTicket(id);
    }

    @RequestMapping(value = "{id}/sendFeedBack", method = RequestMethod.POST)
    public Ticket sendFeedBack(@PathVariable(value = "id") Long id, @RequestBody String feedBack){
        return ticketService.sendFeedBack(id, feedBack);
    }

}
