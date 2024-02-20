package com.sistemabibilioteca.sistemabibilioteca.controller;

import com.sistemabibilioteca.sistemabibilioteca.model.Aluno;
import com.sistemabibilioteca.sistemabibilioteca.repository.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/aluno")

public class AlunoController {
     @Autowired
    private AlunoRepository alunoDAO;

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoDAO.findAll();
    }

    @GetMapping("/matricula")
    public Aluno listarPorMatricula(String matricula) {
        System.out.println(matricula);
        return alunoDAO.BuscaPorMatricula(matricula);
    }

    @PostMapping("/cadastroAluno")
    public Aluno cadastrarAluno(String matricula, String nome, String cpf, String endereco) {
        return alunoDAO.cadastraAluno(matricula,nome,cpf,endereco);
    }
}
