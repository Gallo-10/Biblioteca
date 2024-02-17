package com.sistemabibilioteca.sistemabibilioteca.dao;

import com.sistemabibilioteca.sistemabibilioteca.model.Livro;

import java.util.List;

public interface LivroDAO {
    Livro findById(String id);
    List<Livro> findAll();
    Livro save(Livro livro);
}
