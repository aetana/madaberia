package agritech.madaberia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    private Long id;
    private String name;
    private String code;


    @ManyToOne(optional = false)
    private Zone zone;

    @ManyToMany(mappedBy = "woredas")
    private List<Kebele> kebeles;
}
