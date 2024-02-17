package com.sistemabibilioteca.sistemabibilioteca.repository;


import com.sistemabibilioteca.sistemabibilioteca.dao.DebitoDAO;
import com.sistemabibilioteca.sistemabibilioteca.model.Debito;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DebitoRepository implements DebitoDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Debito> listarDebitos(String matricula) {
        return entityManager.createQuery("SELECT d FROM debitos d WHERE d.aluno.matricula = :matricula", Debito.class)
                .setParameter("matricula", matricula)
                .getResultList();
    }

    @Transactional
    @Override
    public Debito adicionarDebito(Debito debito) {
        entityManager.persist(debito);
        return debito;
    }
}
