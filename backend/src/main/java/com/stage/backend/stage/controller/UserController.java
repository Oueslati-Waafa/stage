package com.stage.backend.stage.controller;

import com.stage.backend.stage.model.User;
import com.stage.backend.stage.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
    @Autowired
    UserDetailsServiceImpl service;


    @GetMapping("/api/student")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public String studentAccess() {
        return ">>> student Contents!";
    }

    @GetMapping("/api/teacher")
    @PreAuthorize("hasRole('TEACHER') or hasRole('ADMIN')")
    public String teacherAccess() {
        return ">>> Teacher prespective";
    }

    @GetMapping("/api/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return ">>> Admin Contents";
    }

    @PostMapping("/api/admin/adduser")
    @PreAuthorize("hasRole('ADMIN')")
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }


    @GetMapping("api/admin/users")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public List<User> findAllUsers() {
        return service.getUser();
    }

    @GetMapping("/api/admin/user/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public User findUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @GetMapping("/api/admin/{name}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public Optional<User> findUserByName(@PathVariable String name) {
        return service.getUserByName(name);
    }

    @PutMapping("/api/admin/update")
    @PreAuthorize("hasRole('ADMIN')")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/api/admin/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }

}