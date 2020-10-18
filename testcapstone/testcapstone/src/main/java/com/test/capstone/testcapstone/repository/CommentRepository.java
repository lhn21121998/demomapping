package com.test.capstone.testcapstone.repository;

import com.test.capstone.testcapstone.entity.Comment;
import com.test.capstone.testcapstone.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findCommentByPostId(Post post);
}
