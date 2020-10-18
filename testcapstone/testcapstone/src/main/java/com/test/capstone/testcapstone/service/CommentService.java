package com.test.capstone.testcapstone.service;

import com.test.capstone.testcapstone.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment insertComment(int postId, Comment comment);

    Comment updateComment(int postId, Comment comment);

    List<Comment> getAllComment(int postId);

    Comment getCommentById(int id);
}
