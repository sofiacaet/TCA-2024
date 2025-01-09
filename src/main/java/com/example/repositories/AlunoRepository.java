package com.example.repositories;

import java.sql.SQLException;

import com.example.DAO.AlunoDAOImpl;
import com.example.models.Aluno;

public class AlunoRepository {
    AlunoDAOImpl alunoDAOImpl;

    public AlunoRepository() throws SQLException {
        this.alunoDAOImpl = new AlunoDAOImpl();
    }

    public void salvar(Aluno aluno) throws SQLException {

        alunoDAOImpl.inserir(aluno);
    }

    public void listarAlunos() {
        alunoDAOImpl.getAlunos();
    }
}
