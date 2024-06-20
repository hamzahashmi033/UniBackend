package com.example.blog.controllers;

import com.example.blog.payloads.CategoryDto;
import com.example.blog.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    //    create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createdCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
    }
    //    update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
    CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto,categoryId);
    return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }
//    delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer categoryId){
    this.categoryService.deleteCategory(categoryId);
    return ResponseEntity.ok(Map.of("message","Category deleted Successfully"));
}
//   get single
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer categoryId){
    return  ResponseEntity.ok(this.categoryService.getCategory(categoryId));
    }
//    get All
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>>getAllCategories(){
    return  ResponseEntity.ok(this.categoryService.getCategories());
}
}
