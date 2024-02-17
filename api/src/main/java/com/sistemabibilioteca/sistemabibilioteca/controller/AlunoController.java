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

    @GetMapping("/{matricula}")
    public Aluno listarPorMatricula(String matricula) {
        return alunoDAO.BuscaPorMatricula(matricula);
    }

    @PostMapping
    public Aluno cadastrarAluno(Aluno aluno) {
        if (aluno.getMatricula().isEmpty() || aluno.getNome().isEmpty() || aluno.getCpf().isEmpty() || aluno.getEndereco().isEmpty()) {
            throw new RuntimeException("Dados inválidos");
        }
        return alunoDAO.cadastraAluno(aluno);
    }
}
