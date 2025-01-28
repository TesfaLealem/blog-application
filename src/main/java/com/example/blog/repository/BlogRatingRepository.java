package com.example.blog.repository;

import com.example.blog.models.Blog;
import com.example.blog.models.BlogRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRatingRepository extends JpaRepository<BlogRating, Long> {
    Optional<BlogRating> findByUserIdAndBlogId(Long userId, Long blogId);
    List<BlogRating> findByBlogId(Long blogId);
}