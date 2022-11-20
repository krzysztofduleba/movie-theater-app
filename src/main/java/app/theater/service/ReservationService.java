package app.theater.service;

import app.theater.model.Reservation;
import app.theater.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public Iterable<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    public Iterable<Reservation> findAllByUser(Long userId) {
        return reservationRepository.findAllByUser(userId);
    }
}
