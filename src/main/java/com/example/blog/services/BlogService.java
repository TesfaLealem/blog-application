package com.example.blog.services;

import com.example.blog.exceptions.ResourceNotFoundException;
import com.example.blog.models.Blog;
import com.example.blog.models.BlogRating;
import com.example.blog.models.Comment;
import com.example.blog.models.User;
import com.example.blog.repository.BlogRatingRepository;
import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;
    private final BlogRatingRepository blogRatingRepository;



    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Long id, Blog updatedBlog, User user) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
        if (!blog.getUser().getId().equals(user.getId())) {
            throw new AccessDeniedException("Unauthorized");
        }
        blog.setTitle(updatedBlog.getTitle());
        blog.setContent(updatedBlog.getContent());
        return blogRepository.save(blog);
    }

    public void deleteBlog(Long id, User user) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
        if (!blog.getUser().getId().equals(user.getId())) {
            throw new AccessDeniedException("Unauthorized");
        }
        blogRepository.delete(blog);
    }


    public List<Blog> searchBlogs(String searchQuery) {
        List<Blog> blogsByTitle = blogRepository.findByTitleContainingIgnoreCase(searchQuery);
        List<Blog> blogsByContent = blogRepository.findByContentContainingIgnoreCase(searchQuery);
        List<Blog> blogsByTag = blogRepository.findByTagsContainingIgnoreCase(searchQuery);

        // Combine the results from all searches and remove duplicates if necessary
        blogsByTitle.addAll(blogsByContent);
        blogsByTitle.addAll(blogsByTag);

        return blogsByTitle; // You can further filter duplicates based on your needs
    }


    public Blog getBlogWithCommentsAndRatings(Long blogId) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new RuntimeException("Blog not found"));
        List<Comment> comments = commentRepository.findByBlog_Id(blogId);
        List<BlogRating> ratings = blogRatingRepository.findByBlogId(blogId);
        blog.setComments(comments);
        blog.setRatings(ratings);
        return blog;
    }


}
