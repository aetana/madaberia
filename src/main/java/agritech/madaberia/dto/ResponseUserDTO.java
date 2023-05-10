package agritech.madaberia.dto;

import agritech.madaberia.domain.Permission;
import agritech.madaberia.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResponseUserDTO {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String userName;
    private String password;
    private Role role;
    private List<Permission> permissionList;
}
