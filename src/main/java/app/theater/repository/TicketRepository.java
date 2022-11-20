package app.theater.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.theater.model.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {}