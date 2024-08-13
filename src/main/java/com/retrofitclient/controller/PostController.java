package com.retrofitclient.controller;

import com.retrofitclient.model.Post;
import com.retrofitclient.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/retrofit")
public class PostController {

    @Autowired
    private PostService postService;
    @GetMapping("/posts")
    public List<Post> fetchPosts(){

        return postService.fetchPosts();

    }
    @GetMapping("/posts/{id}")
    public Post fetchPost(@PathVariable int id){
        return postService.fetchPostById(id);
    }

    @PostMapping("/posts")
    public Post creatPost(@RequestBody Post post){
        return postService.createPost(post);

    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable int id) {
        postService.deletePost(id);
    }
}
