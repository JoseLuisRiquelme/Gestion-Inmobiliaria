package cl.praxis.ReporteInmobiliario.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "usr")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String password;
    //private String image;

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "usr_role",
            joinColumns = @JoinColumn(name = "usr_id",referencedColumnName = "usr_id"),
            inverseJoinColumns =@JoinColumn(name = "role_id",referencedColumnName = "role_id")
    )
    private List<Role> roles;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Report> reports;

}
