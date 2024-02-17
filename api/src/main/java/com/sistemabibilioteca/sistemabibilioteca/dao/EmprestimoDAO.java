package com.sistemabibilioteca.sistemabibilioteca.dao;

import java.util.List;
import com.sistemabibilioteca.sistemabibilioteca.model.Emprestimo;

public interface EmprestimoDAO {
    Emprestimo findById(Long id);
    Emprestimo findByAlunoMatricula(String matricula);
    List<Emprestimo> findAll();
    Emprestimo save(Emprestimo emprestimo);

}
