package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//dao역할
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
