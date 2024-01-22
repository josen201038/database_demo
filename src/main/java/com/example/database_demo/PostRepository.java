package com.example.database_demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // 必要に応じてカスタムメソッドを追加
}

