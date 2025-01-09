package com.example.controllers;

import com.example.App;
import com.example.models.Usuario;
import com.example.repositories.UsuarioRepository;
import com.example.utils.Hash;

import javafx.fxml.FXML;
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
        Usuario usuario = repository.buscarPorEmail(email.getText());

        if (usuario == null) {
            System.out.println("EMAIL ERRADO!");
        }else if   (! Hash.verificarSenha(senha.getText(), usuario.getSenha_hash())) 
        {
            System.out.println("SENHA ERRADA!");
        } else
        {
            App.setRoot("telaInicial");
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
