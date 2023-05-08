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
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    @ManyToOne(optional = false)
    private Region region;

    @OneToMany(mappedBy = "zone")
    private List<Woreda> woreda;

    @OneToMany(mappedBy = "zone", cascade = CascadeType.ALL)
    private List<Permission> permissions;
}



