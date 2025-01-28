package com.example.blog.services;

import com.example.blog.exceptions.ResourceNotFoundException;
import com.example.blog.models.Blog;
import com.example.blog.models.Comment;
import com.example.blog.models.User;
import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.CommentRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;

    public CommentService(CommentRepository commentRepository, BlogRepository blogRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
    }

    public Comment createComment(Long blogId, String content, User user) {
        Comment comment = new Comment();
        comment.setBlog(blogRepository.findById(blogId).orElseThrow(() -> new RuntimeException("Blog not found")));
        comment.setUser(user);
        comment.setContent(content);
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long commentId, String content, User user) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new RuntimeException("Comment not found"));
        if (!comment.getUser().equals(user)) {
            throw new RuntimeException("You can only edit your own comments");
        }
        comment.setContent(content);
        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId, User user) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new RuntimeException("Comment not found"));
        if (!comment.getUser().equals(user)) {
            throw new RuntimeException("You can only delete your own comments");
        }
        commentRepository.delete(comment);
    }

    public List<Comment> getCommentsForBlog(Long blogId) {
        return commentRepository.findByBlog_Id(blogId);
    }
}