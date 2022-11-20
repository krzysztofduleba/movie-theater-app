package app.theater.service;

import app.theater.model.Auditorium;
import app.theater.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumService {
    @Autowired
    private AuditoriumRepository auditoriumRepository;

    public void save(Auditorium auditorium) {
        auditoriumRepository.save(auditorium);
    }

    public List<Auditorium> findAll() {
        return auditoriumRepository.findAll();
    }

    public Auditorium findAuditoriumById(Long id) {
        return auditoriumRepository.findAuditoriumById(id);
    }

    public void deleteById(Long id) {
        auditoriumRepository.deleteById(id);
    }
}
