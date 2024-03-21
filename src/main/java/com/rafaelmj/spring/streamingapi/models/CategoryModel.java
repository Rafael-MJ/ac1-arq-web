package com.rafaelmj.spring.streamingapi.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tbl_categorias")
public class CategoryModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_categoria;
    
    private String cat_nome;
    private String cat_descricao;
    
    public UUID getId_categoria() {
        return id_categoria;
    }
    
    public void setId_categoria(UUID id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    public String getCat_nome() {
        return cat_nome;
    }
    
    public void setCat_nome(String cat_nome) {
        this.cat_nome = cat_nome;
    }
    
    public String getCat_descricao() {
        return cat_descricao;
    }
    
    public void setCat_descricao(String cat_descricao) {
        this.cat_descricao = cat_descricao;
    }
}
