package agritech.madaberia.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Kebele {
    @Id
    private Long id;
    private String name;
    private String code;

    @ManyToOne(optional = false)
    private Woreda woreda;
}
