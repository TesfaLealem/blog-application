package com.example.blog.controllers;

import com.example.blog.models.User;
import com.example.blog.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PutMapping("/{userId}/profile")
    public User updateUserProfile(@PathVariable Long userId, @RequestBody User updatedUser) {
        return userService.updateUserProfile(userId, updatedUser);
    }

    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam(value = "query") String searchQuery) {
        return userService.searchUsers(searchQuery);
    }
}