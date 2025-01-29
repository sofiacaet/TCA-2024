package com.example.controllers;

import com.example.App;
import com.example.models.Cliente;
import com.example.repositories.ClienteRepository;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AdicionarClienteController 
{
    @FXML
    private TextField nomeCliente;

    @FXML
    private TextField cpfCliente;

    @FXML
    private TextField numeroCliente;

    @FXML
    private Button adicionar;

    @FXML
    private Button cancelar;

    ClienteRepository repository;


    @FXML
    private void adicionar() throws Exception
    {
        try {
            repository = new ClienteRepository();
            if (repository.buscarPorCpf(cpfCliente.getText()) ==  null) 
            {
                
            Cliente cliente = new Cliente(
                    nomeCliente.getText(), 
                    cpfCliente.getText(),
                    numeroCliente.getText() 
                    );

                    repository.cadastrar(cliente);
                    App.setRoot("telaInicial");
            }else{
                throw new Exception("ERRO: Já existe um cliente com esse CPF!");
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
    private void cancelar()
    {
        try {
            App.setRoot("telaInicial");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    

}