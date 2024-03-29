package com.sistemabibilioteca.sistemabibilioteca.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "emprestimos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dataEmprestimo;
    private Date dataPrevista;
    
    @OneToOne
    @Nullable
    private Devolucao devolucao;
    @ManyToOne
    private Aluno aluno;
}
