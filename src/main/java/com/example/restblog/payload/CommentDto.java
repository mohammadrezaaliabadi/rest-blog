package com.example.restblog.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Tag(name = "CommentDto",description = "Comment model information")
@Data
public class CommentDto {

    @Schema(description = "Comment id")
    private long id;
    // name should not be null or empty
    @Schema(description = "Comment name")
    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    // email should not be null or empty
    // email field validation
    @Schema(description = "Comment email")
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;

    // comment body should not be bull or empty
    // Comment body must be minimum 10 characters
    @NotEmpty
    @Schema(description = "Comment body")
    @Size(min = 10, message = "Comment body must be minimum 10 characters")
    private String body;
}
