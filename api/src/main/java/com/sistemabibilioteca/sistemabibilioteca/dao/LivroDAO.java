package com.sistemabibilioteca.sistemabibilioteca.dao;

import com.sistemabibilioteca.sistemabibilioteca.model.Livro;

import java.util.List;

public interface LivroDAO {
    Livro BuscaPorId(String id);
    List<Livro> findAll();
    Livro cadastraLivro(boolean disponivel,boolean exemplarBiblioteca,int prazo,String isbn,String editora);
}
