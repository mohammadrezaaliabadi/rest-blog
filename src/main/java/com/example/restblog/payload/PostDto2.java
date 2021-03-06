package com.example.restblog.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PostDto2 {
    private Long id;
    @NotEmpty
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;
    @NotEmpty
    private String content;
    private List<String> tags;
}
