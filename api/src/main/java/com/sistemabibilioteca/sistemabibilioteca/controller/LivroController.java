package com.sistemabibilioteca.sistemabibilioteca.controller;


import com.sistemabibilioteca.sistemabibilioteca.model.Livro;
import com.sistemabibilioteca.sistemabibilioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/livro")
public class LivroController {
    @Autowired
    private LivroRepository livroDAO;

    @GetMapping
    public List<Livro> listarLivros() {
        return livroDAO.findAll();
    }

    @PostMapping("/cadastroLivro")
    public Livro cadastrarLivro(boolean disponivel,boolean exemplarBiblioteca,int prazo,String isbn,String editora) {
        return livroDAO.cadastraLivro(disponivel,exemplarBiblioteca,prazo,isbn,editora);
    }
}
