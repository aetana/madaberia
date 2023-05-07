package agritech.madaberia.dto;

import agritech.madaberia.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResponseUserDTO {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Role role;
}
