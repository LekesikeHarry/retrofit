package com.retrofitclient.service;

import com.retrofitclient.model.Post;
import com.retrofitclient.util.RetrofitUtil;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostServiceImpl implements PostService {
    private Retrofit retrofit;
    private PostApi postApi;

    public PostServiceImpl() {
        retrofit = RetrofitUtil.getRetrofitInstance();
        postApi = retrofit.create(PostApi.class);
    }
    @Override
    public List<Post> fetchPosts() {
        List<Post> postResponse = new ArrayList<>();
        Call<List<Post>> fetchPostCall = postApi.fetchPosts();
        try {
            Response<List<Post>> response = fetchPostCall.execute();
            if (response.isSuccessful() && response.body() != null) {
                postResponse = response.body();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return postResponse;
    }

    @Override
    public Post fetchPostById(int id) {
        Post post = null;
        Call<Post> postCall = postApi.fetchPost(id);

        try {
            Response<Post> response = postCall.execute();
            if (response.isSuccessful() && response.body() != null) {
                post = response.body();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public Post createPost(Post post) {
        Post newpost = null;
        Call<Post> postCall = postApi.createPost(post);

        try {
            Response<Post> response = postCall.execute();
            if (response.isSuccessful() && response.body() != null) {
                System.out.println(response.body());
                post = response.body();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return post;
    }
    @Override
    public void deletePost(int id) {
        Post newpost = null;
        Call<Void> postCall = postApi.deletePost(id);

        try {
            Response<Void> response = postCall.execute();
            if (response.isSuccessful() && response.body() != null) {
                System.out.println("Post deleted successfully");
                System.out.println(response.body());

            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
