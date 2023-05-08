package agritech.madaberia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @ManyToOne
    private Region region;

    @ManyToOne
    private Zone zone;

    @ManyToOne
    private Woreda woreda;

    @ManyToOne
    private Kebele kebele;

}
