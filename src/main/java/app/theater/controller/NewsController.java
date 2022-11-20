package app.theater.controller;

import app.theater.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping
    public String getNews(Model model) {
        model.addAttribute("news", newsService.findAll());
        model.addAttribute("highlightedNews", newsService.findByHighlighted(true));
        return "news";
    }
}