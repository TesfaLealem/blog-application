package com.example.blog.repository;

import com.example.blog.models.Blog;
import com.example.blog.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBlog_Id(Long blogId);
}