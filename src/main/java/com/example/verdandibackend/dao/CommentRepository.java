package com.example.verdandibackend.dao;

import com.example.verdandibackend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
