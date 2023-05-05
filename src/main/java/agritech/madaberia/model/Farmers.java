package agritech.madaberia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Farmers {
    @Id
    private Long id;
    private String name;
    private String fingerPrint;
    private String phoneNumber;
}
