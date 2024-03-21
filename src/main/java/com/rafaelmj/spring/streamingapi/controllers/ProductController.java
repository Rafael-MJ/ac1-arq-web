package com.rafaelmj.spring.streamingapi.controllers;

import com.rafaelmj.spring.streamingapi.dtos.ProductDTO;
import com.rafaelmj.spring.streamingapi.models.ProductModel;
import com.rafaelmj.spring.streamingapi.services.ProductService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired()
    ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductDTO newProductDto) {
        return productService.saveProduct(newProductDto);
    }

    @GetMapping()
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable(value = "id") UUID productId) {
        return productService.getProductById(productId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProductById(@RequestBody @Valid ProductDTO productDto,
                                                  @PathVariable(value = "id") UUID productId) {
        return productService.updateProductById(productDto, productId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductById(@PathVariable(value = "id") UUID productId) {
        return productService.deleteProductById(productId);
    }
}
