package com.sistemabibilioteca.sistemabibilioteca.repository;

import com.sistemabibilioteca.sistemabibilioteca.dao.ItemEmprestimoDAO;

import com.sistemabibilioteca.sistemabibilioteca.model.ItemEmprestimo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemEmprestimoRepository implements ItemEmprestimoDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public ItemEmprestimo BuscaPorId(Long id) {
        return entityManager.createQuery("SELECT a FROM itens_emprestimo a WHERE a.id = :id", ItemEmprestimo.class)
                            .setParameter("id", id)
                            .getSingleResult();
    }

    @Override
    public ItemEmprestimo BuscaPorEmprestimo(Long emprestimoId) {
        return entityManager.createQuery("SELECT a FROM itens_emprestimo a WHERE a.emprestimoId = :emprestimoId", ItemEmprestimo.class)
                            .setParameter("emprestimoId", emprestimoId)
                            .getSingleResult();
    }

    @Override
    public boolean BuscaPorLivro(Long livroId) {
        return entityManager.createQuery("SELECT EXISTS (SELECT a FROM itens_emprestimo a WHERE a.livro.id = :livro_id)", Boolean.class)
                .setParameter("livro_id", livroId)
                .getSingleResult();
    }

    @Override
    public List<ItemEmprestimo> findAll() {
        return entityManager.createQuery("SELECT a FROM itens_emprestimo a", ItemEmprestimo.class).getResultList();
    }

    @Transactional
    @Override
    public ItemEmprestimo cadastraItemEmprestimo(ItemEmprestimo itemEmprestimo) {
        entityManager.persist(itemEmprestimo);
        return itemEmprestimo;
    }
}
