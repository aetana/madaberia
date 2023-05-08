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
public class Woreda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;


    @ManyToOne(optional = false)
    private Zone zone;

    @OneToMany(mappedBy = "woreda")
    private List<Kebele> kebele;

    @OneToMany(mappedBy = "woreda", cascade = CascadeType.ALL)
    private List<Permission> permissions;
}
