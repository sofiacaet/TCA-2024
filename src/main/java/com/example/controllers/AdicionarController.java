package com.example.controllers;

import com.example.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class AdicionarController 
{
    
    @FXML
    private TextField nomeLivro;

    @FXML
    private TextField preco;

    @FXML
    private TextField idLivro;

    @FXML
    private MenuButton quantidade;

    @FXML
    private MenuButton categoria;


    @FXML
    private Button adicionar;

    @FXML
    private Button cancelar;
    
    @FXML
    private void adicionar()
    {
        
    }

    @FXML
    private void cancelar()
    {
        try {
            App.setRoot("telaInicial");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    
    
}
