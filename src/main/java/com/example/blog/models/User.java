package com.example.blog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User implements UserDetails {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the primary key value
    private Long id; // Primary key

    private String username;
    private String password;
    private String email;
    private String name;
    private String bio;
    private String profilePicture;


    // Other fields like roles, etc.

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return the user's authorities (roles, permissions, etc.)
        return null; // You can return roles or permissions here
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement your account expiration logic if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement your account lock logic if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement your credentials expiration logic if needed
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement your enabled check if needed
    }

    // Getters and setters for other fields (like email, etc.)


    // Other getters and setters
}
