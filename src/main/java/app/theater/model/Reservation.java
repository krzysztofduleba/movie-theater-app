package app.theater.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Screening screening;
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
    private String status;

    public Reservation() {}

    public Reservation(User user, Screening screening, List<Ticket> tickets, String status) {
        this.user = user;
        this.screening = screening;
        this.tickets = tickets;
        this.status = status;
    }
}
