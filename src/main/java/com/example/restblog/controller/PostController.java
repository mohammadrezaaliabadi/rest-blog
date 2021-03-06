package com.example.restblog.controller;

import com.example.restblog.payload.PostDto;
import com.example.restblog.payload.PostDto2;
import com.example.restblog.service.PostService;
import com.example.restblog.utils.AppConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Tag(name ="PostController" ,description = "CRUD Rest APIs for Post resources")

@RestController
@RequestMapping("/api")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Operation(summary = "Get All Post", description = "Get All Posts REST API")

    @GetMapping("/v1/posts")
    public ResponseEntity getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return new ResponseEntity(postService.getAllPosts(pageNo, pageSize, sortBy, sortDir), HttpStatus.OK);
    }

    @Operation(summary = "Create Post", description = "Create post By admin Role")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/v1/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody @Valid PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    // get post by id
    @Operation(summary = "Get  Post", description = "Get Single Post REST API Version 1")
    @GetMapping(value = "/v1/posts/{id}")
    public ResponseEntity<PostDto> getPostByIdV1(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }
    @Operation(summary = "Get Post", description = "Get All Posts REST API Version 2")

    @GetMapping(value = "/v2/posts/{id}")
    public ResponseEntity<PostDto2> getPostByIdV2(@PathVariable(name = "id") long id) {
        PostDto postById = postService.getPostById(id);
        PostDto2 postDto2 = new PostDto2();
        postDto2.setId(postById.getId());
        postDto2.setTitle(postById.getTitle());
        postDto2.setDescription(postById.getContent());
        postDto2.setContent(postById.getContent());
        postDto2.setTags(List.of("Java","Spring"));
        return ResponseEntity.ok(postDto2);
    }
    @Operation(summary = "Update Post", description = "Update Post by admin Role")

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/v1/posts/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody @Valid PostDto postDto, @PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(postService.updatePost(postDto, id), HttpStatus.OK);
    }
    @Operation(summary = "Delete Post", description = "Delete Post by admin Role")

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/v1/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") Long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }

}
