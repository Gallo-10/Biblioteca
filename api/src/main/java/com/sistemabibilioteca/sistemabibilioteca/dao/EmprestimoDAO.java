package com.sistemabibilioteca.sistemabibilioteca.dao;

import java.util.List;
import com.sistemabibilioteca.sistemabibilioteca.model.Emprestimo;

public interface EmprestimoDAO {
    Emprestimo BuscaPorId(Long id);
    Emprestimo BuscaPorAlunoMatricula(String matricula);
    List<Emprestimo> findAll();
    Emprestimo cadastraEmprestimo(Emprestimo emprestimo);

}
