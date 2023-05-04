package agritech.madaberia.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agritech.madaberia.domain.User;
import agritech.madaberia.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping()
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable int id) {
        User updatedUser = userService.updateUser(user, id);
        if (updatedUser != null) {
            return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Can not update User with id " + id + " not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        // if boolean used d/t response entity can be returned
        userService.deleteUser(id);

        return new ResponseEntity<String>("User with id " + id + " not found", HttpStatus.NOT_FOUND);

    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        // if boolean used d/t response entity can be returned
        User user = userService.getUser(id);
        if (user != null) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }

        return new ResponseEntity<String>("User with id " + id + " not found", HttpStatus.NOT_FOUND);

    }

    @GetMapping()
    public List<User> getAllUser() {

        return userService.getAllUser();

    }
}
