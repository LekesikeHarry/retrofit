package com.retrofitclient.service;

import com.retrofitclient.model.Post;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface PostApi {

    @GET("/posts")
    Call<List<Post>> fetchPosts();

    @GET("/posts/{id}")
    Call<Post> fetchPost(@Path("id") int id);

    @POST("/posts")
    Call<Post> createPost(@Body Post post);

    @DELETE("/posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
