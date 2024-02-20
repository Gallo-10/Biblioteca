package com.sistemabibilioteca.sistemabibilioteca.controller;

import com.sistemabibilioteca.sistemabibilioteca.model.Aluno;
import com.sistemabibilioteca.sistemabibilioteca.model.Debito;
import com.sistemabibilioteca.sistemabibilioteca.model.Emprestimo;
import com.sistemabibilioteca.sistemabibilioteca.model.Livro;
import com.sistemabibilioteca.sistemabibilioteca.repository.AlunoRepository;
import com.sistemabibilioteca.sistemabibilioteca.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/cadastrarEmprestimo")
    public Emprestimo cadastrarEmprestimo(String matricula, Date dataEmprestimo, Livro livros ) {

        //verifica se o aluno está cadastrado
        Aluno aluno = alunoRepository.BuscaPorMatricula(matricula);
        if (aluno == null) {
            throw new RuntimeException("O aluno não esta cadastrado");
        }

        //verifica se o aluno possui debitos
        List<Debito> debitos = debitoController.listarDebitosAluno(matricula);
        if (!debitos.isEmpty()) {
            throw new RuntimeException("O aluno possui débitos pendentes");
        }

        itemEmprestimoController.verificarLivro(livros);

        //cria emprestimo
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataEmprestimo(dataEmprestimo);
        emprestimo.setDataPrevista(new Date());
        emprestimo.setDevolucao(null);
        emprestimoDAO.cadastraEmprestimo(emprestimo);

        emprestimo.setAluno(aluno);

        

        itemEmprestimoController.cadastrarItemEmprestimo(livros, emprestimo);

        return emprestimo;   
    }
}
