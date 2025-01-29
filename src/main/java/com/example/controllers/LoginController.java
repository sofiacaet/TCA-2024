package com.example.controllers;

import com.example.App;
import com.example.models.Usuario;
import com.example.repositories.UsuarioRepository;
import com.example.utils.Hash;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController 
{
    @FXML
    private TextField email;
    
    @FXML
    private TextField senha;

    @FXML
    private Button entrar;

    @FXML
    private Button cadastrar;

    @FXML
    private Button cadastrarse;

    UsuarioRepository repository;

    @FXML
    private void entrar() throws Exception
    {
        repository = new UsuarioRepository();
        try {
            Usuario usuario = repository.buscarPorEmail(email.getText());

            if (usuario == null) {
                throw new Exception("ERRO: E-mail errado!");
            }else if   (!Hash.verificarSenha(senha.getText(), usuario.getSenha_hash())) 
            {
                throw new Exception("ERRO: Senha errada!");
            } else
            {
                App.setRoot("telaInicial");
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("ERRO");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    @FXML
    private void cadastrar()
    {

    }

    @FXML
    private void cadastrarse()
    {
        try {
            App.setRoot("telaCadastro");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}