package com.servicenow.app.respository;

import com.servicenow.app.entity.TestTable;
import com.servicenow.app.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> getTicketsByUserId(Long userId);

    @Query(value = "Select ticket.* from Ticket ticket where ticket.agent_id is null order by severity ASC",
    nativeQuery = true)
    List<Ticket> getUnAssignedTickets();
}
