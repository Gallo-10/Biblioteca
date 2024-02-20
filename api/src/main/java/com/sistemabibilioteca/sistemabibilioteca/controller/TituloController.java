package com.sistemabibilioteca.sistemabibilioteca.controller;

import com.sistemabibilioteca.sistemabibilioteca.model.Titulo;
import com.sistemabibilioteca.sistemabibilioteca.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/titulo")
public class TituloController {
    @Autowired
    private TituloRepository tituloDAO;

    @GetMapping
    public List<Titulo> listarTitulos() {
        return tituloDAO.findAll();
    }

    @PostMapping("/cadastroTitulo")
    public Titulo cadastrarTitulo(int prazo,String isbn,String editora) {
        return tituloDAO.cadastraTitulo(prazo,isbn,editora);
    }
}
