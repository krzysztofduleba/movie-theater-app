package app.theater.controller;

import app.theater.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/screenings")
public class ScreeningController {
    @Autowired
    private ScreeningService screeningService;

    @GetMapping
    public String getScreenings(Model model) {
        model.addAttribute("screenings", screeningService.findAll());
        return "screenings";
    }
}
