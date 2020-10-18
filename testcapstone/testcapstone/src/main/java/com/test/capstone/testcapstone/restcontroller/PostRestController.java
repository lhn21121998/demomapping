package com.test.capstone.testcapstone.restcontroller;

import com.test.capstone.testcapstone.entity.Post;
import com.test.capstone.testcapstone.service.PostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-v1")
public class PostRestController {

    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public ResponseEntity<Post> insertPost(@RequestBody Post post) {
        try {
            postService.insertPost(post);
            return ResponseEntity.status(HttpStatus.OK).body(post);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/post")
    public ResponseEntity<Void> updatePost(@RequestBody Post post) {
        try {
            postService.updatePost(post);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/post")
    public ResponseEntity<List<Post>> getAllPost() {
        try {
            List<Post> posts = postService.getAllPost();
            if(posts != null) {
                return ResponseEntity.status(HttpStatus.OK).body(posts);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable int id) {
        try {
            Post post = postService.getPostById(id);
            if (post != null) {
                return ResponseEntity.status(HttpStatus.OK).body(post);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
