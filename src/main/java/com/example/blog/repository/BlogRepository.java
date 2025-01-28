package com.example.blog.repository;

import com.example.blog.models.Blog;
import com.example.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {


    List<Blog> findByTitleContainingIgnoreCase(String title);

    List<Blog> findByContentContainingIgnoreCase(String content);

    // Assuming tags is a list of strings or a custom object
    List<Blog> findByTagsContainingIgnoreCase(String tag);
}