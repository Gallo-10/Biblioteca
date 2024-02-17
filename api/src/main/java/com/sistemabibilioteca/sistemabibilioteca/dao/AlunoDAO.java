package com.sistemabibilioteca.sistemabibilioteca.dao;



import java.util.List;

import com.sistemabibilioteca.sistemabibilioteca.model.Aluno;

public interface AlunoDAO {

    Aluno findByMatricula(String matricula);// metodo pra buscar por matricula

    Aluno findByCpf(String cpf);// metodo pra buscar por cpf

    Aluno findByNome(String nome);// metodo pra buscar por nome

    List<Aluno> findAll();// metodo pra listar todos alunos

    Aluno save(Aluno aluno);// metodo pra cadastrar aluno
}
