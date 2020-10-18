package com.test.capstone.testcapstone.restcontroller;

import com.test.capstone.testcapstone.entity.Comment;
import com.test.capstone.testcapstone.entity.Post;
import com.test.capstone.testcapstone.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-v1/post")
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{postId}/comment")
    public ResponseEntity<Comment> insertComment(@PathVariable int postId, @RequestBody Comment comment) {
        try {
            commentService.insertComment(postId, comment);
            return ResponseEntity.status(HttpStatus.OK).body(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{postId}/comment")
    public ResponseEntity<Comment> updateComment(@PathVariable int postId, @RequestBody Comment comment) {
        try {
            commentService.updateComment(postId, comment);
            return ResponseEntity.status(HttpStatus.OK).body(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{postId}/comment")
    public ResponseEntity<List<Comment>> getAllComments(@PathVariable int postId) {
        try {
            List<Comment> comments = commentService.getAllComment(postId);
            if (comments != null) {
                return ResponseEntity.status(HttpStatus.OK).body(comments);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable int id) {
        try {
            Comment comment = commentService.getCommentById(id);
            if (comment != null) {
                return ResponseEntity.status(HttpStatus.OK).body(comment);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
