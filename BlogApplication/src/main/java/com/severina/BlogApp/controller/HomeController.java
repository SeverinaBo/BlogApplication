package com.severina.BlogApp.controller;

import com.severina.BlogApp.Entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/")
    public String home(Model model) {
        List<BlogPost> posts = blogPostService.getAll();
        model.addAttribute("posts", posts);
        return "home_page";
    }
}
