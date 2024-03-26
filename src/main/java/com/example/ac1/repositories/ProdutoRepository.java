package com.example.ac1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto inserir(Produto produto) {
        entityManager.merge(produto);
        return produto;
    }

    public List<Produto> selecionarTodos() {
        return entityManager.createQuery("SELECT p FROM Produto p", Produto.class)
                .getResultList();
    }
    
    public List<Produto> selecionarPorId(Long id) {
        String jpql = "SELECT p FROM Produto p WHERE p.id = :id";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
    
    @Transactional
    public Produto editar(Produto produto) {
        return entityManager.merge(produto);
    }
    
    @Transactional
    public void excluir(Long id) {
        Produto produto = entityManager.find(Produto.class, id);
        if (produto != null) {
            entityManager.remove(produto);
        }
    }
    
}
