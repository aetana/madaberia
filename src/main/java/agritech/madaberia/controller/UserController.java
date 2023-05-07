package agritech.madaberia.controller;

import java.util.List;

import agritech.madaberia.dto.RequestUserDTO;
import agritech.madaberia.dto.ResponseUserDTO;
import agritech.madaberia.exception.ResourceNotFound;
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
    public void addUser(@RequestBody RequestUserDTO user) {
        userService.addUser(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@RequestBody RequestUserDTO user, @PathVariable int id) {
        try{
            ResponseUserDTO updatedUser = userService.updateUser(user, id);
            return new ResponseEntity<ResponseUserDTO>(updatedUser, HttpStatus.OK);
        }catch (ResourceNotFound e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        // if boolean used d/t response entity can be returned
        try{
            userService.deleteUser(id);
            return new ResponseEntity<String>("User with id " + id + " deleted", HttpStatus.OK);
        }catch (ResourceNotFound e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        try{
            ResponseUserDTO user = userService.getUser(id);
            return new ResponseEntity<ResponseUserDTO>(user, HttpStatus.OK);
        }catch (ResourceNotFound e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public List<ResponseUserDTO> getAllUser() {
        return userService.getAllUser();
    }
}
