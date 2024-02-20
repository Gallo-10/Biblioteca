package com.sistemabibilioteca.sistemabibilioteca.controller;



import com.sistemabibilioteca.sistemabibilioteca.model.Emprestimo;
import com.sistemabibilioteca.sistemabibilioteca.model.ItemEmprestimo;
import com.sistemabibilioteca.sistemabibilioteca.model.Livro;
import com.sistemabibilioteca.sistemabibilioteca.repository.ItemEmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/itememprestimo")
public class ItemEmprestimoController {
    @Autowired
    private ItemEmprestimoRepository itemEmprestimoDAO;

    public List<ItemEmprestimo> listarItensEmprestimo() {
        return itemEmprestimoDAO.findAll();
    }

    public ItemEmprestimo cadastrarItemEmprestimo(ItemEmprestimo itemEmprestimo) {
        return itemEmprestimoDAO.cadastraItemEmprestimo(itemEmprestimo);
    }

    public void verificarLivro(Livro livro) {
        if (itemEmprestimoDAO.BuscaPorLivro(livro.getId())) { 
            throw new RuntimeException("Livro já reservado");
        }
        if (livro.isExemplarBiblioteca()) {
            throw new RuntimeException("Livro é exemplar da biblioteca e não pode ser emprestado");
        }
    }
    


    @SuppressWarnings("deprecation")
    public ItemEmprestimo cadastrarItemEmprestimo(Livro livro, Emprestimo emprestimo) {
        ItemEmprestimo itemEmprestimo = new ItemEmprestimo();
        itemEmprestimo.setDataPrevista(new Date(2024, Calendar.JANUARY, 2));
        itemEmprestimo.setLivro(livro);
        itemEmprestimo.setEmprestimo(emprestimo);
        cadastrarItemEmprestimo(itemEmprestimo);
        return itemEmprestimo;
    }
    
}
