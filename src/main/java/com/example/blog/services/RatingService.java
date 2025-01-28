package com.example.blog.services;

import com.example.blog.models.Blog;
import com.example.blog.models.BlogRating;
import com.example.blog.models.User;
import com.example.blog.repository.BlogRatingRepository;
import com.example.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private final BlogRatingRepository blogRatingRepository;
    private final BlogRepository blogRepository;


    public RatingService(BlogRatingRepository blogRatingRepository, BlogRepository blogRepository) {
        this.blogRatingRepository = blogRatingRepository;
        this.blogRepository = blogRepository;
    }

    public BlogRating createOrUpdateRating(Long userId, Long blogId, int rating) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new RuntimeException("Blog not found"));
        BlogRating existingRating = blogRatingRepository.findByUserIdAndBlogId(userId, blogId).orElse(null);

        if (existingRating == null) {
            BlogRating newRating = new BlogRating();
            newRating.setUser(blog.getUser()); // Setting the user
            newRating.setBlog(blog);
            newRating.setRatingValue(rating);
            return blogRatingRepository.save(newRating);
        } else {
            existingRating.setRatingValue(rating);
            return blogRatingRepository.save(existingRating);
        }
    }
}