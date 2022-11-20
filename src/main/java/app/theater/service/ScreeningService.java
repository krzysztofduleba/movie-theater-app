package app.theater.service;

import app.theater.model.Auditorium;
import app.theater.model.Screening;
import app.theater.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreeningService {
    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private AuditoriumService auditoriumService;

    public void save(Screening screening) {
        Auditorium auditorium = auditoriumService.findAuditoriumById(screening.getAuditorium().getId());
        screening.setAvailableSeatsNumber(auditorium.getSeatsNumber());
        screeningRepository.save(screening);
    }

    public Screening update(Screening screening, int ticketsNumber) {
        screening.setAvailableSeatsNumber(screening.getAvailableSeatsNumber() - ticketsNumber);
        screeningRepository.save(screening);
        return screening;
    }

    public List<Screening> findAll() {
        return screeningRepository.findAll();
    }

    public Optional<Screening> findById(@Param("screeningId") Long screeningId) {
        return screeningRepository.findById(screeningId);
    }

    public void deleteById(Long id) {
        screeningRepository.deleteById(id);
    }
}
