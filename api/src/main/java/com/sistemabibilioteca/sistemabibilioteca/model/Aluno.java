package com.sistemabibilioteca.sistemabibilioteca.model;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "aluno")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Aluno {

    @Column(unique = true)
    @Id
    private String matricula;

    private String nome;

    @Column(unique = true)
    private String cpf;

    private String endereco;
}