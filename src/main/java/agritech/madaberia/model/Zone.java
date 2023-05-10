package agritech.madaberia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private Long id;
    private String name;
    private String code;

    @ManyToOne(optional = false)
    private Region region;

    @OneToMany(mappedBy = "zone")
    private List<Woreda> woredas;
}



