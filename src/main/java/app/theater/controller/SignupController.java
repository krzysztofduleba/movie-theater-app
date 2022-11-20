package app.theater.controller;

import app.theater.dto.UserRegistrationDto;
import app.theater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public String getSignUp(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "signup";
    }

    @PostMapping()
    public String postSignup(Model model, @ModelAttribute("user") UserRegistrationDto registrationDto) {
        model.addAttribute("user", new UserRegistrationDto());
        if (userService.save(registrationDto) == true) {
            return "redirect:/signup?success";
        } else {
            return "redirect:/signup?error";
        }
    }
}