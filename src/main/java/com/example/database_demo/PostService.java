package com.example.database_demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public void savePost(Post post) {
        postRepository.save(post);
    }

    public List<Post> getActivePosts() {
        return postRepository.findByState(true);
    }

    public List<Post> getInactivePosts() {
        return postRepository.findByState(false);
    }

    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public void toggleState(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post ID: " + id));
        post.setState(!post.isState());
        postRepository.save(post);
    }
}

