package com.rafaelmj.spring.streamingapi.services;

import com.rafaelmj.spring.streamingapi.dtos.ProductDTO;
import com.rafaelmj.spring.streamingapi.models.CategoryModel;
import com.rafaelmj.spring.streamingapi.models.ProductModel;
import com.rafaelmj.spring.streamingapi.repositories.CategoryRepository;
import com.rafaelmj.spring.streamingapi.repositories.ProductRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired()
    ProductRepository productRepository;
    
    @Autowired()
    CategoryRepository categoryRepository;
    
    @Transactional()
    public ResponseEntity<ProductModel> saveProduct(ProductDTO newProductDto) {
        var newProductModel = new ProductModel();
        
        BeanUtils.copyProperties(newProductDto, newProductModel);
        
        CategoryModel category = categoryRepository.findById(newProductDto.id_categoria())
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada"));
        
        newProductModel.setId_categoria(category);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(newProductModel));
    }

    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    public ResponseEntity<Object> getProductById(UUID productId) {
        Optional<ProductModel> productModel = productRepository.findById(productId);

        if (productModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product id not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(productModel);
    }

    @Transactional()
    public ResponseEntity<Object> updateProductById(ProductDTO productDto, UUID productId) {
        Optional<ProductModel> productModel = productRepository.findById(productId);

        if (productModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product id not found");
        }

        var updatedProduct = productModel.get();
        BeanUtils.copyProperties(productDto, updatedProduct);
        
        CategoryModel category = categoryRepository.findById(productDto.id_categoria())
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada"));
        
        updatedProduct.setId_categoria(category);
        
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(updatedProduct));
    }

    @Transactional()
    public ResponseEntity<Object> deleteProductById(UUID productId) {
        Optional<ProductModel> productModel = productRepository.findById(productId);

        if (productModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product id not found");
        }

        productRepository.delete(productModel.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfuly");
    }
}
