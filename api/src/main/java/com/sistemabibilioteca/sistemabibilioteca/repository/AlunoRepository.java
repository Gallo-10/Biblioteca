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
    public Aluno findByMatricula(String matricula) {
        return entityManager.createQuery("SELECT a FROM aluno a WHERE a.matricula = :matricula", Aluno.class)
                            .setParameter("matricula", matricula)
                            .getSingleResult();
    }

    @Override
    public Aluno findByCpf(String cpf) {
        return entityManager.createQuery("SELECT a FROM aluno a WHERE a.cpf = :cpf", Aluno.class)
        .setParameter("cpf", cpf)
        .getSingleResult();
    }

    @Override
    public Aluno findByNome(String nome) {
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
    public Aluno save(Aluno aluno) {
        entityManager.persist(aluno);
        return aluno;
    }
}
