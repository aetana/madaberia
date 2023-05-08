package agritech.madaberia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Kebele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    @ManyToOne(optional = false)
    private Woreda woreda;

    @OneToMany
    private List<Farmer> farmers;

    @OneToMany(mappedBy = "kebele", cascade = CascadeType.ALL)
    private List<Permission> permissions;

}
