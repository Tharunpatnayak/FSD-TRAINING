package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(
            @RequestBody User user) {

        try {

            User savedUser =
            userService.registerUser(user);

            return ResponseEntity.ok(
                    savedUser
            );

        }
        catch(Exception e) {

            return ResponseEntity.badRequest()
                    .body(
                            e.getMessage()
                    );

        }

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(
            @RequestBody User user) {

        User validUser =
        userService.loginUser(
                user.getUsername(),
                user.getPassword()
        );

        if(validUser != null) {

            return ResponseEntity.ok(
                    validUser
            );

        }

        return ResponseEntity.badRequest()
                .body(
                        "Invalid Username Or Password"
                );

    }

}