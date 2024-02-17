package com.sistemabibilioteca.sistemabibilioteca.repository;

import com.sistemabibilioteca.sistemabibilioteca.dao.EmprestimoDAO;
import com.sistemabibilioteca.sistemabibilioteca.model.Emprestimo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmprestimoRepository implements EmprestimoDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Emprestimo BuscaPorId(Long id) {
        return entityManager.createQuery("SELECT a FROM emprestimos a WHERE a.id = :id", Emprestimo.class)
                            .setParameter("id", id)
                            .getSingleResult();
    }

    @Override
    public Emprestimo BuscaPorAlunoMatricula(String matricula) {
        return entityManager.createQuery("SELECT a FROM emprestimos a WHERE a.matricula = :matricula", Emprestimo.class)
                            .setParameter("matricula", matricula)
                            .getSingleResult();
    }

    @Override
    public List<Emprestimo> findAll() {
        return entityManager.createQuery("SELECT a FROM emprestimos a", Emprestimo.class).getResultList();
    }

    @Transactional
    @Override
    public Emprestimo cadastraEmprestimo(Emprestimo emprestimo) {
        entityManager.persist(emprestimo);
        return emprestimo;
    }
}