package com.sistemabibilioteca.sistemabibilioteca.repository;

import com.sistemabibilioteca.sistemabibilioteca.dao.TituloDAO;
import com.sistemabibilioteca.sistemabibilioteca.model.Titulo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TituloRepository implements TituloDAO {
    @Autowired
    private EntityManager entityManager;
    @Override
    public Titulo BuscaPorId(Long id) {
        return entityManager.createQuery("SELECT a FROM titulos a WHERE a.id = :id", Titulo.class)
                            .setParameter("id", id)
                            .getSingleResult();
    }

    @Override
    public Titulo BuscaPorIsbn(String isbn) {
        return entityManager.createQuery("SELECT a FROM titulos a WHERE a.isbn = :isbn", Titulo.class)
                            .setParameter("isbn", isbn)
                            .getSingleResult();
    }

    @Override
    public List<Titulo> findAll() {
        return entityManager.createQuery("SELECT a FROM titulos a", Titulo.class).getResultList();
    }

    @Transactional
    @Override
    public Titulo cadastraTitulo(Titulo titulo) {
        entityManager.persist(titulo);
        return titulo;
    }
}
