package com.test.capstone.testcapstone.service;

import com.test.capstone.testcapstone.entity.Comment;
import com.test.capstone.testcapstone.entity.Post;
import com.test.capstone.testcapstone.repository.CommentRepository;
import com.test.capstone.testcapstone.repository.PostRepository;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment insertComment(int postId, Comment comment) {
        try {
            Post post = postRepository.findById(postId).orElse(null);
            Date date = new Date(System.currentTimeMillis());
            comment.setPostId(post);
            comment.setCreateDate(date);
            comment.setUpdateDate(date);
            return commentRepository.save(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Comment updateComment(int postId, Comment comment) {
        try {
            Post post = postRepository.findById(postId).orElse(null);
            Comment existedComment = commentRepository.findById(comment.getCommentId()).orElse(null);
            if(existedComment != null) {
                Date date = new Date(System.currentTimeMillis());
                existedComment.setCreateDate(existedComment.getCreateDate());
                existedComment.setUpdateDate(date);
                existedComment.setContent(comment.getContent());
                existedComment.setPostId(post);
                return commentRepository.save(existedComment);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Comment> getAllComment(int postId) {
        try {
            Post post = postRepository.findById(postId).orElse(null);
            return commentRepository.findCommentByPostId(post);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Comment getCommentById(int id) {
        try {
            Comment comment = commentRepository.findById(id).orElse(null);
            if(comment != null) {
                return comment;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
