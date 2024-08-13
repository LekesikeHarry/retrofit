package com.retrofitclient.service;

import com.retrofitclient.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    public List<Post> fetchPosts();

    public Post fetchPostById(int id);

    public Post createPost(Post post);

    public void deletePost(int id);
}
