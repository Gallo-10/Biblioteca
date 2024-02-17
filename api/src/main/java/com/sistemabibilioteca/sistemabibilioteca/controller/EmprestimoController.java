package com.sistemabibilioteca.sistemabibilioteca.controller;

import com.sistemabibilioteca.sistemabibilioteca.model.Aluno;
import com.sistemabibilioteca.sistemabibilioteca.model.Debito;
import com.sistemabibilioteca.sistemabibilioteca.model.Emprestimo;
import com.sistemabibilioteca.sistemabibilioteca.model.Livro;
import com.sistemabibilioteca.sistemabibilioteca.repository.AlunoRepository;
import com.sistemabibilioteca.sistemabibilioteca.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/emprestimo")
public class EmprestimoController{
    @Autowired
    private EmprestimoRepository emprestimoDAO;

    @Autowired
    private ItemEmprestimoController itemEmprestimoController;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private DebitoController debitoController;

    
    public List<Emprestimo> listarEmprestimos() {
        return emprestimoDAO.findAll();
    }

    @SuppressWarnings("deprecation")
    
    public Emprestimo cadastrarEmprestimo(String matricula, Date dataEmprestimo, List<Livro> livros ) {
        //verifica se o aluno está cadastrado
        Aluno aluno = alunoRepository.findByMatricula(matricula);
        if (aluno == null) {
            throw new RuntimeException("O aluno não esta cadastrado");
        }

        //verifica se o aluno possui pendências
        List<Debito> debitos = debitoController.listarDebitosAluno(matricula);
        if (!debitos.isEmpty()) {
            throw new RuntimeException("O aluno possui débitos pendentes");
        }

        itemEmprestimoController.verificarLivros(livros);

        //cria emprestimo
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataEmprestimo(dataEmprestimo);
        emprestimo.setDataPrevista(new Date(2024,10,1));
        emprestimo.setDevolucao(null);
        emprestimo.setAluno(aluno);

        emprestimoDAO.save(emprestimo);

        itemEmprestimoController.cadastrarListaItensEmprestimo(livros, emprestimo);

        return emprestimo;   
    }
}
