package com.example.controllers;

import com.example.App;

import javafx.fxml.FXML;

public class InicialController 
{
    
    @FXML
    private void adicionar()
    {
        try {
            App.setRoot("telaAdicionar");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void editar()
    {
        try {
            App.setRoot("telaEditar");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void registrar()
    {
        try {
            App.setRoot("telaRegistrar");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void remover()
    {
        try {
            App.setRoot("telaRemover");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void verTransacoes()
    {
        try {
            App.setRoot("telaTransacoes");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void listar()
    {
        try {
            App.setRoot("telaEstoque");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    @FXML
    private void adicionarCliente()
    {
        try {
            App.setRoot("telaAdicionarCliente");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
