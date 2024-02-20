package com.sistemabibilioteca.sistemabibilioteca.repository;

import com.sistemabibilioteca.sistemabibilioteca.dao.LivroDAO;
import com.sistemabibilioteca.sistemabibilioteca.model.Livro;
import com.sistemabibilioteca.sistemabibilioteca.model.Titulo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LivroRepository implements LivroDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Livro BuscaPorId(String id) {
        return entityManager.createQuery("SELECT a FROM livros a WHERE a.id = :id", Livro.class)
                            .setParameter("id", id)
                            .getSingleResult();
    }

    @Override
    public List<Livro> findAll() {
        return entityManager.createQuery("SELECT a FROM livros a", Livro.class).getResultList();
    }

    @Transactional
    @Override

    public Livro cadastraLivro(boolean disponivel,boolean exemplarBiblioteca,int prazo,String isbn,String editora) {

        Titulo titulo = new Titulo();
        titulo.setPrazo(prazo);
        titulo.setIsbn(isbn);
        titulo.setEditora(editora);
        

        entityManager.persist(titulo); // Primeiro, persistimos o 'Titulo'
        entityManager.flush(); // Isso irá gerar o ID para 'titulo'

        Livro livro = new Livro();
        livro.setDisponivel(disponivel);
        livro.setExemplarBiblioteca(exemplarBiblioteca);
        livro.setTitulo(titulo);
        entityManager.persist(livro);
        return livro;
    }   
}
