package com.example.ac1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ac1.models.Categoria;
import com.example.ac1.repositories.CategoriaRepository;

import java.util.List;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {
  
  @Autowired
  private CategoriaRepository categoriaRepository;
  
  @GetMapping()
  public List<Categoria> obterTodos() {
    return categoriaRepository.findAll();
  }
  
  @GetMapping("/nome")
  public List<Categoria> obterPorNome(@RequestParam String nome) {
    return categoriaRepository.findByNomeStartingWith(nome);
  }
  
  @GetMapping("/{id}")
  public Categoria obterPorId(@PathVariable Long id) {
    return categoriaRepository.findByIdWithProdutos(id);
  }
  
  @PostMapping()
  public void inserir(@RequestBody Categoria categoria) {
    categoriaRepository.save(categoria);
  }

}
