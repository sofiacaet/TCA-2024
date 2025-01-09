package com.example.controllers;

import java.sql.SQLException;

import com.example.DAO.AlunoDAOImpl;
import com.example.models.Aluno;
import com.example.repositories.AlunoRepository;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SalvarController {
    @FXML
    private TextField emailTF;

    @FXML
    private TextField nomeTF;

    AlunoRepository alunoRepository;

    @FXML
    void salvar(ActionEvent event) throws SQLException {

        alunoRepository = new AlunoRepository();

        String nome = nomeTF.getText();
        String email = emailTF.getText();

        Aluno aluno = new Aluno(nome, email);

        alunoRepository.salvar(aluno);

    }

    @FXML
    void listar(ActionEvent event) throws SQLException {
        alunoRepository = new AlunoRepository();
        alunoRepository.listarAlunos();
    }
}
