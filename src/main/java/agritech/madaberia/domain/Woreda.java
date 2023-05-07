package agritech.madaberia.domain;

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
    private Long id;
    private String name;
    private String code;


    @ManyToOne(optional = false)
    private Zone zone;

    @OneToMany()
    private List<Kebele> kebeles;
}
