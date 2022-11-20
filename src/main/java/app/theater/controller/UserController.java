package app.theater.controller;

import app.theater.model.Reservation;
import app.theater.model.User;
import app.theater.service.ReservationService;
import app.theater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public String getUserProfile() {
        return "user-account";
    }

    @GetMapping("/tickets")
    public String getUserTickets(Principal principal, Model model) {
        User currentUser = userService.findByEmail(principal.getName());
        Iterable<Reservation> reservations = reservationService.findAllByUser(currentUser.getId());
        model.addAttribute("reservations", reservations);
        return "user-tickets";
    }
}
