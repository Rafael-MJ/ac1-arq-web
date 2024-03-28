package com.example.ac1.controllers;

import com.example.ac1.models.Categoria;
import com.example.ac1.models.Produto;
import com.example.ac1.repositories.CategoriaRepository;
import com.example.ac1.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {
  
  @Autowired
  private ProdutoRepository produtoRepository;
  
  @GetMapping()
  public List<Produto> obterTodos() {
    return produtoRepository.findAll();
  }
  
  @GetMapping("/valor-minimo")
  public List<Produto> obterValorMinimo(@RequestParam double valor) {
    return produtoRepository.findByPrecoGreaterThan(valor);
  }
  
  @GetMapping("/valor-maximo")
  public List<Produto> obterValorMaximo(@RequestParam double valor) {
    return produtoRepository.findByPrecoLessThanEqual(valor);
  }
  
  @GetMapping("/nome")
  public List<Produto> obterPorNome(@RequestParam String nome) {
    return produtoRepository.findByNomeStartingWith(nome);
  }
  
  @PostMapping()
  public void inserir(@RequestBody Produto produto) {
    produtoRepository.save(produto);
  }

}
