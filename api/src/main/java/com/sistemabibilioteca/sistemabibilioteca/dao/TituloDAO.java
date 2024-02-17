package com.sistemabibilioteca.sistemabibilioteca.dao;

import com.sistemabibilioteca.sistemabibilioteca.model.Titulo;

import java.util.List;

public interface TituloDAO {
    Titulo findById(Long id);
    Titulo findByIsbn(String isbn);
    List<Titulo> findAll();
    Titulo save(Titulo titulo);

}