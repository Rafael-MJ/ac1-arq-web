package com.example.ac1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 200, nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private double preco;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonBackReference
    private Categoria id_categoria;

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", valor=" + preco + "]";
    }
}
