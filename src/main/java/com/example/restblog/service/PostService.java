package com.example.restblog.service;

import com.example.restblog.payload.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> getAllPosts();
    PostDto createPost(PostDto postDto);
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);
    void deletePostById(long id);
}
