package agritech.madaberia.domain;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String userName;
    private String password;
    private Role role;
    @OneToMany(mappedBy = "user")
    List<Permission> permission;
}
