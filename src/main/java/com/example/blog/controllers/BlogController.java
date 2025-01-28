package com.example.blog.controllers;

import com.example.blog.models.Blog;
import com.example.blog.models.User;
import com.example.blog.services.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog, @AuthenticationPrincipal User user) {
        blog.setUser(user);
        return ResponseEntity.ok(blogService.createBlog(blog));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog updatedBlog, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(blogService.updateBlog(id, updatedBlog, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id, @AuthenticationPrincipal User user) {
        blogService.deleteBlog(id, user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Blog> searchBlogs(@RequestParam(value = "query") String searchQuery) {
        return blogService.searchBlogs(searchQuery);
    }
}
