package com.example.controllers;

import com.example.App;
import com.example.models.Usuario;
import com.example.repositories.UsuarioRepository;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private TextField confirmarSenha;

    @FXML
    private Button voltar;

    @FXML
    private Button cadastrar;

    UsuarioRepository repository;


    @FXML
    private void cadastrar() throws Exception
    {
        try {
            repository = new UsuarioRepository();

            if (senha.getText().equals(confirmarSenha.getText())) 
            {
                if (repository.buscarPorEmail(email.getText()) == null) 
                {
                    Usuario usuario = new Usuario(email.getText(), senha.getText());
                    repository.cadastrar(usuario);
                    App.setRoot("telaLogin");
                }else
                {
                    throw new Exception("ERRO: Este E-mail já existe!");
                }
                
            }else{
                throw new Exception("ERRO: As senhas nao coincidem!");
            }
        } catch (Exception e) 
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("ERRO");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
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
    private void cadastrarCadastro() throws Exception
    {
        try {
            repository = new UsuarioRepository();

            if (senha.getText().equals(confirmarSenha.getText())) 
            {
                if (repository.buscarPorEmail(email.getText()) == null) 
                {
                    Usuario usuario = new Usuario(email.getText(), senha.getText());
                    repository.cadastrar(usuario);
                    App.setRoot("telaLogin");
                }else
                {
                    throw new Exception("ERRO: Este E-mail já existe!");
                }
                
            }else{
                throw new Exception("ERRO: As senhas nao coincidem!");
            }
        } catch (Exception e) 
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("ERRO");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        
    }
}