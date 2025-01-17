package com.example.controllers;

import com.example.App;
import com.example.models.Livro;
import com.example.repositories.LivroRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EstoqueController 
{
    @FXML
    private TableView<Livro> tableView;

    @FXML
    private TableColumn<Livro, String>  idLivro;

    @FXML
    private TableColumn<Livro, String>  nomeLivro;

    @FXML
    private TableColumn<Livro, Integer>  quantidade;

    @FXML
    private TableColumn<Livro, Double>  preco;

    private final ObservableList<Livro> livros = FXCollections.observableArrayList();
     
    private LivroRepository repository ;

    @FXML
    public void initialize() throws Exception
    {
        idLivro.setCellValueFactory(new PropertyValueFactory<>("idLivro"));
        nomeLivro.setCellValueFactory(new PropertyValueFactory<>("nome"));
        quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        preco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        repository = new LivroRepository();
        livros.addAll(repository.listar());

        tableView.setItems(livros);
    }

    @FXML
    private void voltar()
    {
        try {
            App.setRoot("telaInicial");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }



}
