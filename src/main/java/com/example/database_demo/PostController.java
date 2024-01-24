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
    public String board(Model model) {
        model.addAttribute("posts", postService.getActivePosts());
        return "board";
    }

    @GetMapping("/archive")
    public String archive(Model model) {
        model.addAttribute("posts", postService.getInactivePosts());
        return "archive";
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
        return "redirect:/archive";
    }

    @GetMapping("/toggleGetState/{id}")
    public String toggleGetState(@PathVariable Long id) {
        postService.toggleState(id);
        return "redirect:/";
    }

    @GetMapping("/toggleState/{id}")
    public String togglePostState(@PathVariable Long id) {
        postService.toggleState(id);
        return "redirect:/archive";
    }
}

