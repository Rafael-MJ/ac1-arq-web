package com.rafaelmj.spring.streamingapi;

import com.rafaelmj.spring.streamingapi.dtos.CategoryDTO;
import com.rafaelmj.spring.streamingapi.dtos.ProductDTO;
import com.rafaelmj.spring.streamingapi.models.CategoryModel;
import com.rafaelmj.spring.streamingapi.repositories.CategoryRepository;
import com.rafaelmj.spring.streamingapi.repositories.ProductRepository;
import com.rafaelmj.spring.streamingapi.services.CategoryService;
import com.rafaelmj.spring.streamingapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {
	
	@Bean
	public CommandLineRunner init(@Autowired ProductService productService,
																@Autowired CategoryService categoryService) {
		
		return args -> {
			var alimento = categoryService.saveCategory(new CategoryDTO("alimento", "alimentacao"));
			var limpeza = categoryService.saveCategory(new CategoryDTO("limpeza", "limpeza de casa"));
			
			System.out.println("*** Listar todas as categorias ***");
			System.out.println(categoryService.getAllCategories());
			
			productService.saveProduct(new ProductDTO("banana", 50, alimento.getId_categoria()));
			productService.saveProduct(new ProductDTO("omo", 10, limpeza.getId_categoria()));
			
			System.out.println("Exemplo Listar todos");
			System.out.println(productService.getAllProducts());
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
