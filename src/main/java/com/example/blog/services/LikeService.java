package com.example.blog.services;

import com.example.blog.exceptions.ResourceNotFoundException;
import com.example.blog.models.Blog;
import com.example.blog.models.Like;
import com.example.blog.models.User;
import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.LikeRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final BlogRepository blogRepository;

    public LikeService(LikeRepository likeRepository, BlogRepository blogRepository) {
        this.likeRepository = likeRepository;
        this.blogRepository = blogRepository;
    }

    public void likeBlog(Long userId, Long blogId) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new RuntimeException("Blog not found"));
        Like existingLike = likeRepository.findByUserAndBlog(userId, blogId).orElse(null);
        if (existingLike == null) {
            Like newLike = new Like();
            newLike.setUser(blog.getUser()); // User who is liking the blog
            newLike.setBlog(blog);
            likeRepository.save(newLike);
        } else {
            likeRepository.delete(existingLike); // Unlikes the blog
        }
    }
}