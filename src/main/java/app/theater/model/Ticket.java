package app.theater.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
    private final float price = 10;
}