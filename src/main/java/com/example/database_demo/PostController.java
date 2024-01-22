package com.example.database_demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String showBoard(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "board"; // Thymeleafテンプレート
    }

    @PostMapping("/post")
    public String postMessage(@RequestParam String username, @RequestParam String content) {
        Post newPost = new Post();
        newPost.setUsername(username);
        newPost.setContent(content);
        postService.savePost(newPost);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/";
    }
}

