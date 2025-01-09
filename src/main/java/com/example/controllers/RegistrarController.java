package com.example.controllers;

import com.example.App;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class RegistrarController 
{
    @FXML
    private TextField idLivro;

    @FXML
    private TextField quantidade;

    @FXML
    private TextField valor;

    @FXML
    private TextField cliente;

    @FXML
    private Button registrar;

    @FXML
    private Button cancelar;

    @FXML
    private DatePicker dataVenda;



    @FXML
    private void registrar()
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
