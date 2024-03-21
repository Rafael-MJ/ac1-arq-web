package com.rafaelmj.spring.streamingapi.controllers;

import com.rafaelmj.spring.streamingapi.dtos.CategoryDTO;
import com.rafaelmj.spring.streamingapi.models.CategoryModel;
import com.rafaelmj.spring.streamingapi.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired()
    CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<CategoryModel> saveCategory(@RequestBody @Valid CategoryDTO newCategoryDto) {
        return categoryService.saveCategory(newCategoryDto);
    }

    @GetMapping()
    public ResponseEntity<List<CategoryModel>> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable(value = "id") UUID categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategoryById(@RequestBody @Valid CategoryDTO categoryDto,
                                                  @PathVariable(value = "id") UUID categoryId) {
        return categoryService.updateCategoryById(categoryDto, categoryId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategoryById(@PathVariable(value = "id") UUID categoryId) {
        return categoryService.deleteCategoryById(categoryId);
    }
}
