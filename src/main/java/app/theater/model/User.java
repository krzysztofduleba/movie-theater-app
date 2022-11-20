package app.theater.model;

import lombok.Data;

import java.util.Collection;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {}

    public User(String email, String password, Collection<Role> roles) {
        super();
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
