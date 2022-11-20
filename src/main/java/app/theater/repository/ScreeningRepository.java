package app.theater.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import app.theater.model.Screening;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScreeningRepository extends CrudRepository<Screening, Long> {
    List<Screening> findAll();
    @Query("FROM Screening s join s.movie m WHERE s.id = :screeningId")
    Optional<Screening> findById(@Param("screeningId") Long screeningId);
}