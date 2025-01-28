package com.example.blog.controllers;

import com.example.blog.models.Comment;
import com.example.blog.models.User;
import com.example.blog.services.CommentService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs/{blogId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public Comment createComment(@PathVariable Long blogId, @RequestParam String content, @AuthenticationPrincipal User user) {
        return commentService.createComment(blogId, content, user);
    }

    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable Long blogId, @PathVariable Long commentId, @RequestParam String content, @AuthenticationPrincipal User user) {
        return commentService.updateComment(commentId, content, user);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId, @AuthenticationPrincipal User user) {
        commentService.deleteComment(commentId, user);
    }

    @GetMapping
    public List<Comment> getComments(@PathVariable Long blogId) {
        return commentService.getCommentsForBlog(blogId);
    }
}