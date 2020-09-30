package com.stage.backend.stage.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {

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