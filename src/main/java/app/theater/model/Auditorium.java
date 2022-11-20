package app.theater.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Auditorium {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    private Integer seatsNumber;
    @OneToMany(mappedBy = "auditorium")
    private List<Screening> screenings;
}
