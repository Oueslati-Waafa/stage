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
public class TestRestAPIs {
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


}