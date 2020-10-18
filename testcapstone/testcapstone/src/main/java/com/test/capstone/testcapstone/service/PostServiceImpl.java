package com.test.capstone.testcapstone.service;

import com.test.capstone.testcapstone.entity.Post;
import com.test.capstone.testcapstone.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post insertPost(Post post) {
        try {
            Date date = new Date(System.currentTimeMillis());
            post.setCreateDate(date);
            post.setUpdateDate(date);
            return postRepository.save(post);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Post updatePost(Post post) {
        try {
            Post existedPost = postRepository.findById(post.getPostId()).orElse(null);
            if (existedPost != null) {
                Date date = new Date(System.currentTimeMillis());
                existedPost.setUpdateDate(date);
                existedPost.setTitle(post.getTitle());
                existedPost.setContent(post.getContent());
                existedPost.setCreateDate(existedPost.getCreateDate());
                return postRepository.save(existedPost);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Post> getAllPost() {
        try {
            return postRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Post getPostById(int id) {
        try {
            Post post = postRepository.findById(id).orElse(null);
            if(post != null) {
                return post;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
