package agritech.madaberia.service;

import java.util.List;

import agritech.madaberia.domain.User;

public interface UserService {

    public User addUser(User User);

    public User updateUser(User User, int id);

    public void deleteUser(int id); // return type suggestion

    public User getUser(int id);

    public List<User> getAllUser();

}
