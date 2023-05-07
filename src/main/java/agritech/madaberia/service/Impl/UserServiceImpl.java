package agritech.madaberia.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import agritech.madaberia.dto.RequestUserDTO;
import agritech.madaberia.dto.ResponseUserDTO;
import agritech.madaberia.exception.ResourceNotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agritech.madaberia.domain.User;
import agritech.madaberia.repository.UserRepository;
import agritech.madaberia.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper mapper;

    @Override
    public ResponseUserDTO addUser(RequestUserDTO userDTO) {
        User user = mapper.map(userDTO,User.class);
        User savedUser = userRepository.save(user);
        return mapper.map(savedUser,ResponseUserDTO.class);

    }

    @Override
    public ResponseUserDTO updateUser(RequestUserDTO userDTO, int id) throws ResourceNotFound {
        User user = mapper.map(userDTO, User.class);
        User userFromDB = mapper.map(getUser(id),User.class);

        userFromDB.setFirstName(user.getFirstName());
        userFromDB.setMiddleName(user.getMiddleName());
        userFromDB.setLastName(user.getLastName());
        userFromDB.setPermission(user.getPermission());
        userFromDB.setRole(user.getRole());

        User updatedUser = userRepository.save(userFromDB);
        return mapper.map(updatedUser, ResponseUserDTO.class);
    }

    @Override
    public void deleteUser(int id) throws ResourceNotFound {
        User user = mapper.map(getUser(id),User.class);
        userRepository.delete(user);
    }

    @Override
    public ResponseUserDTO getUser(int id) throws ResourceNotFound {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFound("User not found");
        }
        User user = optionalUser.get();
        return mapper.map(user, ResponseUserDTO.class);
    }

    @Override
    public List<ResponseUserDTO> getAllUser() {
        List<ResponseUserDTO> responseUserDTOS = new ArrayList<>();
        for(User user : userRepository.findAll()){
            responseUserDTOS.add(mapper.map(user,ResponseUserDTO.class));
        }
        return responseUserDTOS;
    }

}
