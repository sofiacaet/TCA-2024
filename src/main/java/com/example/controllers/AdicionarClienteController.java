package com.example.controllers;

import com.example.App;
import com.example.models.Cliente;
import com.example.repositories.ClienteRepository;

import javafx.fxml.FXML;
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
        repository = new ClienteRepository();
        if (repository.buscarPorCpf(cpfCliente.getText()) ==  null) 
        {
            
           Cliente cliente = new Cliente(
                cpfCliente.getText(),
                nomeCliente.getText(), 
                numeroCliente.getText() 
                );

                repository.cadastrar(cliente);
                App.setRoot("telaInicial");
        }else{
           System.out.println("JA EXISTE UM CLIENTE COM ESSE CPF!");
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
