package com.sistemabibilioteca.sistemabibilioteca.controller;


import com.sistemabibilioteca.sistemabibilioteca.model.Debito;
import com.sistemabibilioteca.sistemabibilioteca.repository.DebitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/debito")
public class DebitoController {
    @Autowired
    private DebitoRepository debitoRepository;

    @GetMapping
    public List<Debito> listarDebitosAluno(String matricula) {
        return debitoRepository.listarDebitos(matricula);
    }

    @PostMapping
    public Debito adicionarDebito(Debito debito) {
        return debitoRepository.adicionarDebito(debito);
    }
}
