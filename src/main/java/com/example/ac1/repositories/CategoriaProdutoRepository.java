package com.example.ac1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.CategoriaProduto;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void inserir(CategoriaProduto categoriaProduto) {
        entityManager.merge(categoriaProduto);
    }

    public List<CategoriaProduto> selecionarTodos() {
        return entityManager.createQuery("SELECT c FROM CategoriaProduto c",
                CategoriaProduto.class).getResultList();
    }
}
