package com.example.ac1.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.ac1.models.Categoria;
import com.example.ac1.repositories.CategoriaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/categoria-produto")
public class CategoriaController {
    private CategoriaRepository categoriaProdutoRepository;

    public CategoriaController(
            CategoriaRepository categoriaProdutoRepository) {
        this.categoriaProdutoRepository = categoriaProdutoRepository;
    }

    /*@GetMapping()
    public List<Categoria> selecionarTodos() {
    
    }*/

    @PostMapping()
    public void inserir(@RequestBody Categoria categoria) {
    
    }

}
