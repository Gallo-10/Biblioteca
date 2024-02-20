package com.sistemabibilioteca.sistemabibilioteca.dao;

import com.sistemabibilioteca.sistemabibilioteca.model.Titulo;

import java.util.List;

public interface TituloDAO {
    Titulo BuscaPorId(Long id);
    Titulo BuscaPorIsbn(String isbn);
    List<Titulo> findAll();
    Titulo cadastraTitulo(int prazo,String isbn,String editora);

}