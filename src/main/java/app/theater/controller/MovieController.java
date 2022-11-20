package app.theater.controller;

import app.theater.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public String getMovies(Model model) {
        model.addAttribute("movies", movieService.findAll());
        return "movies";
    }

    @GetMapping("/{id}")
    public String getMovie(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.findMovieById(id));
        return "movie";
    }
}
