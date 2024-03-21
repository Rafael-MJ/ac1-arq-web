package com.rafaelmj.spring.streamingapi.services;

import com.rafaelmj.spring.streamingapi.dtos.CategoryDTO;
import com.rafaelmj.spring.streamingapi.dtos.CategoryDTO;
import com.rafaelmj.spring.streamingapi.models.CategoryModel;
import com.rafaelmj.spring.streamingapi.models.CategoryModel;
import com.rafaelmj.spring.streamingapi.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired()
    CategoryRepository categoryRepository;

    @Transactional()
    public CategoryModel saveCategory(CategoryDTO newCategoryDto) {
        var newCategoryModel = new CategoryModel();
        BeanUtils.copyProperties(newCategoryDto, newCategoryModel);
        return categoryRepository.save(newCategoryModel);
    }

    public List<CategoryModel> getAllCategories() {
        return categoryRepository.findAll();
    }

    public ResponseEntity<Object> getCategoryById(UUID categoryId) {
        Optional<CategoryModel> categoryModel = categoryRepository.findById(categoryId);

        if (categoryModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category id not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(categoryModel);
    }

    @Transactional()
    public ResponseEntity<Object> updateCategoryById(CategoryDTO categoryDto, UUID categoryId) {
        Optional<CategoryModel> categoryModel = categoryRepository.findById(categoryId);

        if (categoryModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category id not found");
        }

        var updatedCategory = categoryModel.get();
        BeanUtils.copyProperties(categoryDto, updatedCategory);
        return ResponseEntity.status(HttpStatus.OK).body(categoryRepository.save(updatedCategory));
    }

    @Transactional()
    public ResponseEntity<Object> deleteCategoryById(UUID categoryId) {
        Optional<CategoryModel> categoryModel = categoryRepository.findById(categoryId);

        if (categoryModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category id not found");
        }

        categoryRepository.delete(categoryModel.get());
        return ResponseEntity.status(HttpStatus.OK).body("Category deleted successfuly");
    }
}
