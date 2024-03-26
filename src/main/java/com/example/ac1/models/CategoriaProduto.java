package com.example.ac1.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CategoriaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String cat_nome;
    
    @Column(nullable = false)
    private String cat_descricao;
    
    @OneToMany(mappedBy = "id_categoria")
    @JsonManagedReference
    private List<Produto> produtos;

    public CategoriaProduto(int id, String nome, String desc) {
        this.id = id;
        this.cat_nome = nome;
        this.cat_descricao = desc;
    }

    public CategoriaProduto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return cat_nome;
    }

    public void setNome(String cat_nome) {
        this.cat_nome = cat_nome;
    }
    
    public String getDescricao() {
        return cat_descricao;
    }
    
    public void setDescricao(String cat_descricao) {
        this.cat_descricao = cat_descricao;
    }
    
    @Override
    public String toString() {
        return "CategoriaProduto [id=" + id + ", nome=" + cat_nome + ", descricao=" + cat_descricao + "]";
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
