package com.severina.BlogApp.Configuration;


import com.severina.BlogApp.Entity.BlogPost;
import com.severina.BlogApp.controller.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Database implements CommandLineRunner {
   /* CommandLineRunner is a simple
    Spring Boot interface with a run method.
    Spring Boot will automatically call the
    run method of all beans implementing
        this interface after the application context has been loaded.*/
@Autowired
private BlogPostService blogPostService;


    @Override
    public void run(String... args) throws Exception {
        List<BlogPost> blogPosts = blogPostService.getAll();

        if(blogPosts.size() == 0) {
            BlogPost blogPost1 = new BlogPost();


        }
    }
}
