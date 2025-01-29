package com.example.controllers;

import com.example.App;
import com.example.models.Livro;
import com.example.models.enums.Status;
import com.example.repositories.LivroRepository;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private ComboBox<String> quantidade;

    @FXML
    private ComboBox<String> categoria;

    @FXML
    private Button adicionar;

    @FXML
    private Button cancelar;

    LivroRepository repository;
    
    @FXML
    private void adicionar() throws Exception
    {
        try {
            repository = new LivroRepository();
            if (repository.buscarId(idLivro.getText()) ==  null) 
            {
                
                Livro livro = new Livro(
                    idLivro.getText(),
                    nomeLivro.getText(), 
                    Integer.parseInt(quantidade.getSelectionModel().getSelectedItem()), //transformando texto em um inteiro
                    categoria.getSelectionModel().getSelectedItem(), 
                    Double.parseDouble(preco.getText()),
                    Status.DISPONIVEL_PRA_VENDA
                    );

                    repository.adicionar(livro);
                    App.setRoot("telaInicial");
            }else{
                throw new Exception("ERRO: Já existe uma livro com esse ISBN!");
           
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("ERRO: INVALIDO!");
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