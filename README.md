Blog Application - Exam Project
Overview

This Blog application is a basic CRUD (Create, Read, Update, Delete) application built using Spring Boot, which supports managing blog posts with tags and user management. It includes features to create, read, update, and delete blog posts and allows searching posts by tags.
Requirements

    Java 17 or higher
    Maven
    Spring Boot 2.x or higher
    MySQL or H2 Database (H2 is used by default in this application)

Features

    Create, Read, Update, and Delete Blog Posts: Manage blog content with title, content, and tags.
    Tag Management: Add and search posts by tags.
    User Authentication: Basic login system (with roles, e.g., Admin and User).
    Search by Tags: Search posts using tags with case-insensitive matching.
Clone the Repository

git clone https://github.com/yourusername/blog-application.git
cd blog-application

Here’s a sample README file content for your exam project:
Blog Application - Exam Project
Overview

This Blog application is a basic CRUD (Create, Read, Update, Delete) application built using Spring Boot, which supports managing blog posts with tags and user management. It includes features to create, read, update, and delete blog posts and allows searching posts by tags.
Requirements

    Java 17 or higher
    Maven
    Spring Boot 2.x or higher
    MySQL or H2 Database (H2 is used by default in this application)

Features

    Create, Read, Update, and Delete Blog Posts: Manage blog content with title, content, and tags.
    Tag Management: Add and search posts by tags.
    User Authentication: Basic login system (with roles, e.g., Admin and User).
    Search by Tags: Search posts using tags with case-insensitive matching.

Installation
Clone the Repository

git clone https://github.com/yourusername/blog-application.git
cd blog-application

Setup Database

use postgres setup
spring.datasource.url=jdbc:mysql://localhost:3306/blogdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

Run the Application

    Using Maven:
mvn clean install
mvn spring-boot:run
Using IDE (e.g., IntelliJ IDEA, Eclipse):
Open the project in your IDE.
Run the main class BlogApplication.java.

The application will start on http://localhost:8080.

Testing the Application

    The application can be tested by accessing the following endpoints:
        POST /api/blog - Create a new blog post.
        GET /api/blog/{id} - Retrieve a specific blog post by ID.
        GET /api/blog - List all blog posts.
        PUT /api/blog/{id} - Update a specific blog post.
        DELETE /api/blog/{id} - Delete a specific blog post.
        GET /api/blog/search?tag={tag} - Search blog posts by tags.

Project Structure

src/
├── main/
│    ├── java/
│    │   └── com.example.blog/
│    │       ├── controller/
│    │       │    └── BlogController.java
│    │       ├── model/
│    │       │    └── Blog.java
│    │       ├── repository/
│    │       │    └── BlogRepository.java
│    │       └── service/
│    │            └── BlogService.java
│    └── resources/
│         └── application.properties

Technologies Used

    Spring Boot: For the backend framework and RESTful API implementation.
    Spring Data JPA: For interacting with the database using JPA repositories.


