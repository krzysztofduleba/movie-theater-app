package app.theater.controller;

import app.theater.service.MovieService;
import app.theater.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private MovieService movieService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("highlightedNews", newsService.findByHighlighted(true));
        model.addAttribute("movies", movieService.findAll());
        return "index";
    }
}
