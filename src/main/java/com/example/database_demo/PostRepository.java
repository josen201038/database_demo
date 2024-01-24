package com.example.database_demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // 必要に応じてカスタムメソッドを追加
    List<Post> findByState(Boolean state);
}

