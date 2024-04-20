package com.example.calendarkursach.controllers;

import com.example.calendarkursach.services.UserService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Data
public class UserController {
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity getUser(@RequestParam String username){
        return ResponseEntity.ok(userService.loadUserByUsername(username));
    }

}
