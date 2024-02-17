package com.sistemabibilioteca.sistemabibilioteca.dao;



import java.util.List;

import com.sistemabibilioteca.sistemabibilioteca.model.Aluno;

public interface AlunoDAO {

    Aluno BuscaPorMatricula(String matricula);// metodo pra buscar por matricula

    Aluno BuscaPorCpf(String cpf);// metodo pra buscar por cpf

    Aluno BuscaPorNome(String nome);// metodo pra buscar por nome

    List<Aluno> findAll();// metodo pra listar todos alunos

    Aluno cadastraAluno(Aluno aluno);// metodo pra cadastrar aluno
}
