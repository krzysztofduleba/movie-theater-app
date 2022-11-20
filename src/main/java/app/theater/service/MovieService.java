package app.theater.service;

import app.theater.model.Movie;
import app.theater.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findMovieById(Long id) {
        return movieRepository.findMovieById(id);
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}
