package com.example.blog.controllers;

import com.example.blog.models.Comment;
import com.example.blog.models.User;
import com.example.blog.services.CommentService;
import com.example.blog.services.LikeService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs/{blogId}/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public void likeBlog(@PathVariable Long blogId, @AuthenticationPrincipal User user) {
        likeService.likeBlog(user.getId(), blogId);
    }
}