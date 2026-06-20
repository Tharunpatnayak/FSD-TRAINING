package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {

        User existingUser =
        userRepository.findByUsername(
                user.getUsername()
        );

        if(existingUser != null) {

            throw new RuntimeException(
                    "Username Already Exists"
            );

        }

        return userRepository.save(user);

    }

    public User loginUser(String username,
                          String password) {

        return userRepository
                .findByUsernameAndPassword(
                        username,
                        password
                );

    }

}