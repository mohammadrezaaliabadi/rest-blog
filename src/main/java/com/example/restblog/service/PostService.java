package com.example.restblog.service;

import com.example.restblog.payload.PostDto;
import com.example.restblog.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto createPost(PostDto postDto);
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);
    void deletePostById(long id);
}
