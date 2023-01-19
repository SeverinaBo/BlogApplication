package com.severina.BlogApp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.severina.BlogApp.Configuration.AccountService;
import com.severina.BlogApp.Entity.BlogPost;

import com.severina.BlogApp.Repositories.BlogPostRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.Optional;



@Controller
@RequestMapping(value = "/posts")
public class PostController{

    @Autowired
    private final BlogPostService blogPostService;

    @Autowired
    private AccountService accountService;
    @Autowired
    private BlogPostRepository blogPostRepository;

    public PostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model) {

        // find post by id
        Optional<BlogPost> optionalPost = this.blogPostService.getBlogPostById(id);

        // if post exists put it in model
        BlogPost blogPost;
        if (optionalPost.isPresent()) {
            blogPost = optionalPost.get();
            model.addAttribute("blogPost", blogPost);
            return "blogPost";
        } else {
            return "404";
        }
    }
        @PostMapping("/blogPsots/{id}")
        @PreAuthorize("isAuthenticated()")
        public String updatePost (@PathVariable Long id, BlogPost blogPost, BindingResult result, Model model){
            Optional<BlogPost> optionalPost = blogPostService.getBlogPostById(id);
            if (optionalPost.isPresent()) {
                BlogPost existingPost = optionalPost.get();

                existingPost.setTitle(blogPost.getTitle());
                existingPost.setContent(blogPost.getContent());

                blogPostService.save(existingPost);
            }
            return "redirect:/blogPosts/" + blogPost.getId();
        }
/*

@Autowired
    public PostController(BlogPostService blogPostService){
        this.blogPostService = blogPostService;
    }
*/


 /*   public String pagePosts(@PageableDefault(size = 5, sort = {"title"}, direction = Sort.Direction.DESC) Pageable pageable,
                            @RequestParam(required = false) String type, Model model){
    model.addAttribute("posts", blogPostService.getBlogPostPage(type, pageable));
    return "blog/posts";
    }*/

        @PostMapping("/create_post")
        public ResponseEntity<String> createPost (@RequestBody BlogPost newPost){
            // Save the new post to the database
            // ...

            // Return a response indicating that the post was successfully created
            return new ResponseEntity<>("Post created successfully!", HttpStatus.CREATED);
        }
    }
