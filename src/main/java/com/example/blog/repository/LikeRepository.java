package com.example.blog.repository;

import com.example.blog.models.Comment;
import com.example.blog.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndBlog(Long userId, Long blogId);
}