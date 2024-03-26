package com.example.ac1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 200, nullable = false)
    private String prod_nome;
    
    @Column(nullable = false)
    private int prod_qtd;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonBackReference
    private CategoriaProduto id_categoria;

    public Produto(Long id, String nome, int qtd) {
        this.id = id;
        this.prod_nome = nome;
        this.prod_qtd = qtd;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return prod_nome;
    }

    public void setNome(String nome) {
        this.prod_nome = nome;
    }

    public int getQtd() {
        return prod_qtd;
    }

    public CategoriaProduto getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(CategoriaProduto id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setQtd(int qtd) {
        this.prod_qtd = qtd;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + prod_nome + ", quantidade=" + prod_qtd + "]";
    }
}
