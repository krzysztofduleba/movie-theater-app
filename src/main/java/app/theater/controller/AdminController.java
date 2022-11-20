package app.theater.controller;

import app.theater.model.Auditorium;
import app.theater.model.Movie;
import app.theater.model.News;
import app.theater.model.Screening;
import app.theater.service.AuditoriumService;
import app.theater.service.MovieService;
import app.theater.service.NewsService;
import app.theater.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public String movies(Model model) {
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("newMovie", new Movie());
        return "admin-movies";
    }

    @PostMapping("/movies/create")
    public String createMovie(Movie movie, Model model) {
        movieService.save(movie);
        return "redirect:/admin/movies";
    }

    @PostMapping("/movies/delete")
    public String deleteMovie(@Param("movieId") String movieId, Model model) {
        movieService.deleteById(Long.parseLong(movieId));
        return "redirect:/admin/movies";
    }

    @GetMapping("/news")
    public String news(Model model) {
        model.addAttribute("news", newsService.findAll());
        model.addAttribute("highlightedNews", newsService.findByHighlighted(true));
        model.addAttribute("newNews", new News());
        model.addAttribute("newNews", new News());
        return "admin-news";
    }

    @PostMapping("/news/create")
    public String createNews(News news, Model model) {
        if(newsService.saveNews(news) == false) {
            return "redirect:/admin/news?error";
        }
        return "redirect:/admin/news";
    }

    @PostMapping("/news/delete")
    public String deleteNews(@Param("newsId") String newsId, Model model) {
        newsService.deleteById(Long.parseLong(newsId));
        model.addAttribute("news", newsService.findAll());
        model.addAttribute("highlightedNews", newsService.findByHighlighted(true));
        model.addAttribute("newNews", new News());
        return "redirect:/admin/news";
    }

    @PostMapping("/news/highlight/add")
    public String addHighlight(@Param("newsId") String newsId, Model model) {
        if(newsService.addHighlight(Long.parseLong(newsId)) == false) {
            return "redirect:/admin/news?highlightError";
        }
        return "redirect:/admin/news?highlightSuccess";
    }

    @PostMapping("/news/highlight/remove")
    public String removeHighlight(@Param("newsId") String newsId, Model model) {
        newsService.deleteHighlight(Long.parseLong(newsId));
        return "redirect:/admin/news?highlightSuccess";
    }

    @GetMapping("/auditoriums")
    public String aud(Model model) {
        model.addAttribute("auditoriums", auditoriumService.findAll());
        model.addAttribute("newAuditorium", new Auditorium());
        return "admin-auditoriums";
    }

    @PostMapping("/auditoriums/create")
    public String createAuditorium(Auditorium auditorium, Model model) {
        auditoriumService.save(auditorium);
        return "redirect:/admin/auditoriums";
    }

    @PostMapping("/auditoriums/delete")
    public String deleteAuditorium(@Param("auditoriumId") String auditoriumId, Model model) {
        auditoriumService.deleteById(Long.parseLong(auditoriumId));
        return "redirect:/admin/auditoriums";
    }

    @GetMapping("/screenings")
    public String screenings(Model model) {
        model.addAttribute("auditoriums", auditoriumService.findAll());
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("screenings", screeningService.findAll());
        model.addAttribute("newScreening", new Screening());
        return "admin-screenings";
    }

    @PostMapping("/screenings/create")
    public String createScreening(Screening screening, Model model) {
        screeningService.save(screening);
        return "redirect:/admin/screenings";
    }

    @PostMapping("/screenings/delete")
    public String deleteScreening(@Param("screeningId") String screeningId, Model model) {
        screeningService.deleteById(Long.parseLong(screeningId));
        return "redirect:/admin/screenings";
    }
}