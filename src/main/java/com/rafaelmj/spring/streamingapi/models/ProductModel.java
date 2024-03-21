package com.rafaelmj.spring.streamingapi.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tbl_produtos")
public class ProductModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_produto;
    
    private String prod_nome;
    private int prod_qtd;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoryModel id_categoria;
    
    public UUID getId_produto() {
        return id_produto;
    }
    
    public void setId_produto(UUID id_produto) {
        this.id_produto = id_produto;
    }
    
    public String getProd_nome() {
        return prod_nome;
    }
    
    public void setProd_nome(String prod_nome) {
        this.prod_nome = prod_nome;
    }
    
    public int getProd_qtd() {
        return prod_qtd;
    }
    
    public void setProd_qtd(int prod_qtd) {
        this.prod_qtd = prod_qtd;
    }
    
    public CategoryModel getId_categoria() {
        return id_categoria;
    }
    
    public void setId_categoria(CategoryModel id_categoria) {
        this.id_categoria = id_categoria;
    }
}
