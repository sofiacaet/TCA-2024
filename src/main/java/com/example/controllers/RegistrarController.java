package com.example.controllers;

import com.example.App;
import com.example.models.Livro;
import com.example.models.Venda;
import com.example.repositories.LivroRepository;
import com.example.repositories.VendaRepository;

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

    VendaRepository repository;
    LivroRepository repositoryLivro;

    @FXML
    private void registrar() throws Exception // garante que não vai parar a aplicação mediante a erro
    {
        repository = new VendaRepository();
        repositoryLivro = new LivroRepository();
        Livro livro = repositoryLivro.buscarId(idLivro.getText());
        if (livro != null) {
            Venda venda = new Venda(livro, Integer.parseInt(quantidade.getText()), cliente.getText());
           repository.registrar(venda);
           App.setRoot("telaInicial");
        }else{
            System.out.println("LIVRO NAO ENCONTRADO!");
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
