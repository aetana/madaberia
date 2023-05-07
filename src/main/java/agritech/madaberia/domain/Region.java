package agritech.madaberia.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Region {
    @Id
    private Long id;
    private String name;
    private String code;

    @OneToMany(mappedBy = "region")
    private List<Zone> zones;
}
