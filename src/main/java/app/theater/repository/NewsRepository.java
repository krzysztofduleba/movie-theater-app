package app.theater.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.theater.model.News;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {
    List<News> findAll();

    List<News> findByHighlighted(Boolean highlighted);

    Integer countByHighlighted(Boolean highlighted);

    Optional<News> findById(Long id);
}
