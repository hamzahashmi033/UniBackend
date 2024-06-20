package com.example.blog.payloads;

import com.example.blog.entity.Category;
import com.example.blog.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private String title;
    private String content;
    private String imageName;
    private Date createdAt;
    private CategoryDto category;
    private UserDto user;
}
