package com.example.controllers;

import com.example.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroController 
{
    @FXML
    private TextField nome;
    
    @FXML
    private TextField email;

    @FXML
    private TextField senha;

    @FXML
    private TextField confirmaSenha;

    @FXML
    private Button voltar;

    @FXML
    private Button cadastrar;


    @FXML
    private void cadastrar()
    {
        try {
            App.setRoot("telaInicial");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void voltar()
    {
        try {
            App.setRoot("telaLogin");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void cadastrarCadastro()
    {

    }

}
