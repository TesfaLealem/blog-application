package com.example.blog.services;

import com.example.blog.exceptions.ResourceNotFoundException;
import com.example.blog.models.User;
import com.example.blog.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUserProfile(Long userId, User updatedUser) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setName(updatedUser.getName());
        user.setBio(updatedUser.getBio());
        user.setProfilePicture(updatedUser.getProfilePicture());

        return userRepository.save(user);
    }

    public List<User> searchUsers(String searchQuery) {
        return userRepository.findByUsernameContainingOrNameContaining(searchQuery, searchQuery);
    }
}