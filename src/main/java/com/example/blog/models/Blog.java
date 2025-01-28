package com.example.blog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "blogs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<BlogRating> ratings;

    @ElementCollection
    @CollectionTable(name = "blog_tags", joinColumns = @JoinColumn(name = "blog_id"))
    @Column(name = "tag")
    private List<String> tags;
}
