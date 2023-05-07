package agritech.madaberia.service;

import java.util.List;

import agritech.madaberia.domain.User;
import agritech.madaberia.dto.RequestUserDTO;
import agritech.madaberia.dto.ResponseUserDTO;
import agritech.madaberia.exception.ResourceNotFound;

public interface UserService {

    public ResponseUserDTO addUser(RequestUserDTO User);

    public ResponseUserDTO updateUser(RequestUserDTO User, int id) throws ResourceNotFound;

    public void deleteUser(int id) throws ResourceNotFound; // return type suggestion

    public ResponseUserDTO getUser(int id) throws ResourceNotFound;

    public List<ResponseUserDTO> getAllUser();

}
