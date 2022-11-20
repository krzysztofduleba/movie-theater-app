package app.theater.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Screening {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date screeningDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Auditorium auditorium;
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date screeningTime;
    private Integer availableSeatsNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
    @OneToMany(mappedBy = "screening", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public Screening() {}
}
