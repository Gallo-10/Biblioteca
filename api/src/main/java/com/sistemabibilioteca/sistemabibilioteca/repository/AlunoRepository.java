package com.sistemabibilioteca.sistemabibilioteca.repository;

import com.sistemabibilioteca.sistemabibilioteca.dao.AlunoDAO;
import com.sistemabibilioteca.sistemabibilioteca.model.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AlunoRepository implements AlunoDAO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public Aluno BuscaPorMatricula(String matricula) {
        return entityManager.createQuery("SELECT a FROM aluno a WHERE a.matricula = :matricula", Aluno.class)
                            .setParameter("matricula", matricula)
                            .getSingleResult();
    }

    @Override
    public Aluno BuscaPorCpf(String cpf) {
        return entityManager.createQuery("SELECT a FROM aluno a WHERE a.cpf = :cpf", Aluno.class)
        .setParameter("cpf", cpf)
        .getSingleResult();
    }

    @Override
    public Aluno BuscaPorNome(String nome) {
        return entityManager.createQuery("SELECT a FROM aluno a WHERE a.nome = :nome", Aluno.class)
                            .setParameter("nome", nome)
                            .getSingleResult();
    }

    @Override
    public List<Aluno> findAll() {
        return entityManager.createQuery("SELECT a FROM aluno a", Aluno.class).getResultList();
    }

    @Transactional
    @Override
    public Aluno cadastraAluno(String matricula, String nome, String cpf, String endereco) {
        Aluno aluno = new Aluno();
        aluno.setMatricula(matricula);
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setEndereco(endereco);
    
        entityManager.persist(aluno);
        return aluno;
    }
}
