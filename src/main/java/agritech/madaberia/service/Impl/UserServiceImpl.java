package agritech.madaberia.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agritech.madaberia.domain.User;
import agritech.madaberia.repository.UserRepository;
import agritech.madaberia.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {

        return userRepository.save(user);

    }

    @Override
    public User updateUser(User input, int id) {

        User user = getUser(id);

        user.setName(input.getName());
        user.setPermission(input.getPermission());
        user.setRole(input.getRole());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {

        User user = getUser(id);
        userRepository.delete(user);
    }

    @Override
    public User getUser(int id) {
        // TODO Auto-generated method stub
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            // throw exception
        }
        User user = optionalUser.get();
        return user;
    }

    @Override
    public List<User> getAllUser() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

}
