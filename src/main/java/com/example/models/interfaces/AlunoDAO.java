package com.example.models.interfaces;

import com.example.models.Aluno;

public interface AlunoDAO {
    public void inserir(Aluno aluno);

    public void alterar(Aluno aluno);

    public void editar(Aluno aluno);

    public void excluir(Aluno aluno);
    public void getAlunos();
}
