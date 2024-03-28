package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.Categoria;
import com.example.ac1.models.Produto;
import com.example.ac1.repositories.CategoriaRepository;
import com.example.ac1.repositories.ProdutoRepository;

@SpringBootApplication
public class AC1Application {

	@Bean
	public CommandLineRunner init(@Autowired ProdutoRepository produtoRepository,
			@Autowired CategoriaRepository categoriaRepository) {
		return args -> {
			Categoria limpeza = Categoria.builder().nome("Limpeza").build();
			Categoria confeitaria = Categoria.builder().nome("Confeitaria").build();
			Categoria enlatados = Categoria.builder().nome("Enlatados").build();
			
			categoriaRepository.save(limpeza);
			categoriaRepository.save(confeitaria);
			categoriaRepository.save(enlatados);
			
			Produto omo = Produto.builder().nome("Omo Clear").preco(25).id_categoria(limpeza).build();
			Produto vanish = Produto.builder().nome("Vanish Black & White").preco(20.0).id_categoria(limpeza).build();
			Produto bolo = Produto.builder().nome("Bolo de Cenoura").preco(15.0).id_categoria(confeitaria).build();
			Produto sardinha = Produto.builder().nome("Sardinha").preco(8.0).id_categoria(enlatados).build();
			
			produtoRepository.save(omo);
			produtoRepository.save(vanish);
			produtoRepository.save(bolo);
			produtoRepository.save(sardinha);
			
			System.out.println("PRODUTOS: Preço > 15:");
			produtoRepository.findByPrecoGreaterThan(15.0).forEach(System.out::println);
			
			System.out.println("\nPRODUTOS: Preço <= 20:");
			produtoRepository.findByPrecoLessThanEqual(20.0).forEach(System.out::println);
			
			System.out.println("\nPRODUTOS: Nome inicia com 'S':");
			produtoRepository.findByNomeStartingWith("S").forEach(System.out::println);
			
			System.out.println("\nCATEGORIAS: Nome inicia com'C':");
			categoriaRepository.findByNomeStartingWith("C").forEach(System.out::println);
			
			System.out.println("\nCATEGORIA: ID = 1 e produtos relacionados:");
			var categoria1 = categoriaRepository.findByIdWithProdutos(1L);
			System.out.println(categoria1.toString() + categoria1.getProdutos());
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AC1Application.class, args);
	}

}
