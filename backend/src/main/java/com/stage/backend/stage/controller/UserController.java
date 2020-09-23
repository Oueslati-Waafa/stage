package com.stage.backend.stage.controller;

import com.stage.backend.stage.models.User;
import com.stage.backend.stage.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private MyUserDetailsService service;

    @PostMapping("/user/addUser")
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/user/addUsers")
    public List<User> addUsers(@RequestBody List<User> users) {
        return service.saveUsers(users);
    }

    @GetMapping("/user/Users")
    public List<User> findAllUsers() {
        return service.getUser();
    }

    @GetMapping("/user/stageById/{id}")
    public User findUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @GetMapping("/user/stage/{name}")
    public Optional<User> findUserByName(@PathVariable String name) {
        return service.getUserByName(name);
    }

    @PutMapping("/user/update")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
}
