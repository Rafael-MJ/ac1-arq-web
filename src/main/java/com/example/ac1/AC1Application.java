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
			@Autowired CategoriaRepository categoriaProdutoRepository) {
		return args -> {
			/* categoriaProdutoRepository.inserir(new Categoria(0, "Alimentação", "Produtos para consumo"));
			categoriaProdutoRepository.inserir(new Categoria(0, "Limpeza", "Produtos para limpeza e higiene"));

			System.out.println("\nEXEMPLO: Listar todas as categorias");
			List<Categoria> listaCategorias = categoriaProdutoRepository.selecionarTodos();
			listaCategorias.forEach(System.out::println);

			produtoRepository.inserir(new Produto(0l, "Banana Nanica", 500));
			produtoRepository.inserir(new Produto(0l, "Vanish tira manchas", 250));

			System.out.println("\nEXEMPLO: Listar todos os produtos");
			List<Produto> listaProdutos = produtoRepository.selecionarTodos();
			listaProdutos.forEach(System.out::println);

			Produto cBanana = listaProdutos.get(0);
			Produto cVanish = listaProdutos.get(1);
			cBanana.setId_categoria(listaCategorias.get(0));
			cVanish.setId_categoria(listaCategorias.get(1));
			produtoRepository.inserir(cBanana);
			produtoRepository.inserir(cVanish);

			System.out.println("\nEXEMPLO: Listar por ID");
			listaProdutos = produtoRepository.selecionarPorId(cBanana.getId());
			listaProdutos.forEach(System.out::println);
			
			System.out.println("\nEXEMPLO: Edição de produto");
			cVanish.setNome("Vanish Black and White (Editado)");
			cVanish.setQtd(100);
			cVanish = produtoRepository.editar(cVanish);
			
			listaProdutos = produtoRepository.selecionarPorId(cVanish.getId());
			listaProdutos.forEach(System.out::println); */
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AC1Application.class, args);
	}

}
