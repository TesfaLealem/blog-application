package com.example.blog.controllers;

import com.example.blog.models.Blog;
import com.example.blog.models.BlogRating;
import com.example.blog.models.User;
import com.example.blog.services.BlogService;
import com.example.blog.services.RatingService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blogs/{blogId}/ratings")
public class BlogRatingController {

    private final RatingService ratingService;
    private final BlogService blogService;

    public BlogRatingController( RatingService ratingService, BlogService blogService) {
        this.ratingService = ratingService;
        this.blogService = blogService;
    }

    @PostMapping
    public BlogRating rateBlog(@PathVariable Long blogId, @RequestParam int rating, @AuthenticationPrincipal User user) {
        return ratingService.createOrUpdateRating(user.getId(), blogId, rating);
    }

    @GetMapping("/{blogId}")
    public Blog getBlogWithCommentsAndRatings(@PathVariable Long blogId) {
        return blogService.getBlogWithCommentsAndRatings(blogId);
    }
}