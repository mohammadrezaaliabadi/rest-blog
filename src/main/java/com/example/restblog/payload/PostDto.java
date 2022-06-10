package com.example.restblog.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Tag(name = "PostDto",description = "Post model information")
@Data
public class PostDto {

    @Schema(description = "Blog post id")
    private long id;

    // title should not be null  or empty
    // title should have at least 2 characters
    @Schema(description = "Blog post title")
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;

    // post description should be not null or empty
    // post description should have at least 10 characters
    @Schema(description = "Blog post description")
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;

    // post content should not be null or empty
    @Schema(description = "Blog post conent")
    @NotEmpty
    private String content;

    @Schema(description = "Blog post comments")
    private Set<CommentDto> comments;
}