package app.theater.controller;

import app.theater.dto.ReservationDto;
import app.theater.model.Reservation;
import app.theater.model.Screening;
import app.theater.model.Ticket;
import app.theater.service.ReservationService;
import app.theater.service.ScreeningService;
import app.theater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/book")
    public String book(@RequestParam String screeningId, Model model) {
        ReservationDto reservationDto = new ReservationDto();
        Optional<Screening> screening = screeningService.findById(Long.parseLong(screeningId));
        screening.ifPresent(s -> reservationDto.setScreening(s));
        model.addAttribute("dto", reservationDto);
        return "booking-book";
    }

    @PostMapping("/checkout")
    public String checkout(ReservationDto reservationDto, Principal principal, Model model) {
        List<Ticket> tickets = new ArrayList<>();
        for(int i = 0; i < reservationDto.getTicketsNumber(); i++) {
            Ticket ticket = new Ticket();
            tickets.add(ticket);
        }
        Optional<Screening> findScreening =  screeningService.findById(reservationDto.getScreening().getId());
        Screening foundScreening = findScreening.get();
        foundScreening = screeningService.update(foundScreening, reservationDto.getTicketsNumber());
        Reservation reservation = new Reservation(userService.findByEmail(principal.getName()), foundScreening, tickets, "Reserved");
        reservationService.save(reservation);
        model.addAttribute("dto", reservationDto);
        return "booking-checkout";
    }
}
