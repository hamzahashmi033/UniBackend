package com.example.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Integer categoryId;
    @NotBlank
    @Size(min = 5,message = "Size should not be less than 4.")
    private String categoryTitle;
    @NotBlank
    @Size(min = 10,message = "Size should not be less than 10.")
    private String categoryDescription;
}
