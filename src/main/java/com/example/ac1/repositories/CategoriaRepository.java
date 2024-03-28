package com.example.ac1.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Categoria;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
  List<Categoria> findByNomeStartingWith(String nome);
  
  @EntityGraph(attributePaths = {"produtos"})
  @Query("SELECT c FROM Categoria c LEFT JOIN FETCH c.produtos WHERE c.id = :id")
  Categoria findByIdWithProdutos(Long id);
}

