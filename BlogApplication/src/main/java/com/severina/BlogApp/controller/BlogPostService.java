package com.severina.BlogApp.controller;

import com.severina.BlogApp.Entity.BlogPost;
import com.severina.BlogApp.Repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class BlogPostService {


    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostService (BlogPostRepository blogPostRepository){
        this.blogPostRepository = blogPostRepository;
    }




    public List<BlogPost> getAll() {
        return blogPostRepository.findAll();
    }


 /*   public Page<BlogPost> getBlogPostPage(String blogPostTitle, Pageable pageable){
        if(blogPostTitle == null || blogPostTitle.isBlank() || blogPostTitle.equalsIgnoreCase("lang"))
            return blogPostRepository.findAll(pageable);
        return blogPostRepository.findAllByTitle(blogPostTitle, pageable);
    }*/

    public Optional<BlogPost> getBlogPostById(Long postId){
        return blogPostRepository.findById(postId);
    }

    public BlogPost save(BlogPost blogPost) {
        if (blogPost.getId() == null) {
            blogPost.setCreatedAt(LocalDateTime.now());
        }
        blogPost.setUpdatedAt(LocalDateTime.now());
        return blogPostRepository.save(blogPost);
    }

    public void delete(BlogPost post) {
        blogPostRepository.delete(post);
    }

}
