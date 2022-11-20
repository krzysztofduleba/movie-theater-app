package app.theater.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.theater.model.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    public List<Movie> findAll();
    public Movie findMovieById(Long id);
}