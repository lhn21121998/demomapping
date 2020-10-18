package com.test.capstone.testcapstone.service;

import com.test.capstone.testcapstone.entity.Post;

import java.util.List;

public interface PostService {
    Post insertPost(Post post);

    Post updatePost(Post post);

    List<Post> getAllPost();

    Post getPostById(int id);
}
