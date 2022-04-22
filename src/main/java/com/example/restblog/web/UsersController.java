package com.example.restblog.web;

import com.example.restblog.data.User;
import com.example.restblog.data.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {
    private UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    private List<User> getUser() {
        List<User> users = new ArrayList<>();

        return users;
    }

    @GetMapping("{userID}")
    public Optional<User> getUserById(@PathVariable Long userID) {
        return userRepository.findById(userID);
    }

    @GetMapping("/getByUsername")
    public void getByUsername(@RequestParam String username) {
        System.out.println("The Username is " + username);
    }

    @GetMapping("/getByEmail")
    public void getByEmail(@RequestParam String email) {
        System.out.println("users email is : " + email);
    }

    @PostMapping
    private void createUser(@RequestBody User newUser) {
        User user = newUser;
        user.setCreatedAt(LocalDate.now());
        user.setRole(User.Role.USER);
        userRepository.save(user);
        System.out.println("Ready to add user." + newUser);
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User newUser) {
        System.out.println("Ready to update user." + id + newUser);
    }

    @PutMapping("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword) {
//        User user = new User(id, "user 1", "email 1", "1111", null, User.Role.ADMIN,null);
//        if (oldPassword != null && oldPassword.equals(user.getPassword())){
//            user.setPassword(newPassword);
//            System.out.println("successfully created new password.");
//        }
//        System.out.println(user.getPassword());
        System.out.println("changing password to " + newPassword);
    }

    @DeleteMapping("{userId}")
    private void deleteUser(@PathVariable Long userId) {
        System.out.println("ready to delete User." + userId);
    }
}
