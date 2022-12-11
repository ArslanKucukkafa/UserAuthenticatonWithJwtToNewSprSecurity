package com.example.fieldauthapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class userController {

    @PostMapping("/register")
    public ResponseEntity register(){
       return ResponseEntity.ok("Hello");
    }

    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.ok("Hello");
    }


    @GetMapping("/user")
    public String user(){
        return "Hello, this user";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Hello, this is admin";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello, this is admin";
    }

}
