package app.theater.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.theater.model.Reservation;

import java.util.Optional;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    public Iterable<Reservation> findAll();
    public Optional<Reservation> findById(Long id);
    @Query("FROM Reservation r WHERE r.user.id = ?1")
    public Iterable<Reservation> findAllByUser(Long userId);
}