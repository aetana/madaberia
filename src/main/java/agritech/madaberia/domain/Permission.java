package agritech.madaberia.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "UserPermission")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne
    User user;

    @OneToOne
    Region region;
    @OneToOne
    Zone zone;
    @OneToOne
    Woreda woreda;
    @OneToOne
    Kebele kebele;

}

//permisson group <- users
//
