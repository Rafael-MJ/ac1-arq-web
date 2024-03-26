package com.example.ac1.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.ac1.models.CategoriaProduto;
import com.example.ac1.repositories.CategoriaProdutoRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/categoria-produto")
public class CategoriaController {
    private CategoriaProdutoRepository categoriaProdutoRepository;

    public CategoriaController(
            CategoriaProdutoRepository categoriaProdutoRepository) {
        this.categoriaProdutoRepository = categoriaProdutoRepository;
    }

    @GetMapping()
    public List<CategoriaProduto> selecionarTodos() {
        return categoriaProdutoRepository.selecionarTodos();
    }

    @PostMapping()
    public void inserir(@RequestBody CategoriaProduto categoria) {
        categoriaProdutoRepository.inserir(categoria);
    }

}
