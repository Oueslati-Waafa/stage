package com.stage.backend.stage;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRessource {
    @GetMapping("/student")
    public String student()
    {
        String msg="<h1>Hello student</h1>";
        return  msg;
    }

    @GetMapping("/teacher")
    public String teacher()
    {
        String msg="<h1>Hello teacher</h1>";
        return  msg;
    }

    @GetMapping("/admin")
    public String admin()
    {
        String msg="<h1>Hello admin</h1>";
        return  msg;
    }

    @GetMapping("/")
    public String home()
    {
        String msg="<h1>Hello World</h1>";
        return  msg;
    }

}
