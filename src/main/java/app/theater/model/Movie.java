package app.theater.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String url;
    @OneToMany(mappedBy = "movie")
    private List<Screening> screenings;
}
