package app.theater.repository;

import org.springframework.data.repository.CrudRepository;
import app.theater.model.Auditorium;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditoriumRepository extends CrudRepository<Auditorium, Long> {
    public List<Auditorium> findAll();
    public Auditorium findAuditoriumById(Long id);
}
