package com.sistemabibilioteca.sistemabibilioteca.dao;

import com.sistemabibilioteca.sistemabibilioteca.model.ItemEmprestimo;
import java.util.List;

public interface ItemEmprestimoDAO {
    ItemEmprestimo BuscaPorId(Long id);
    ItemEmprestimo BuscaPorEmprestimo(Long emprestimoId);
    boolean BuscaPorLivro(Long livroId);
    List<ItemEmprestimo> findAll();
    ItemEmprestimo cadastraItemEmprestimo(ItemEmprestimo itemEmprestimo);
}
