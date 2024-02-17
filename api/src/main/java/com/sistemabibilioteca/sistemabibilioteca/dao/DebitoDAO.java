package com.sistemabibilioteca.sistemabibilioteca.dao;

import com.sistemabibilioteca.sistemabibilioteca.model.Debito;
import java.util.List;

public interface DebitoDAO {
    List<Debito> listarDebitos(String matricula); //metodo para listar debito dos alunos pela matricula
    Debito adicionarDebito(Debito debito);  //metodo para adicionar um debito a um aluno
}