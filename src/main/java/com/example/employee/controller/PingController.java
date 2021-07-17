package com.example.employee.controller;

import com.example.employee.exception.EmployeeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @Value("${spring.profiles.active}")
    private String profile;

    @GetMapping("/ping")
    public ResponseEntity ping(){
        return ResponseEntity.ok().body("pong "+profile);
    }

}

