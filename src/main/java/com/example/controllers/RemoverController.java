package com.example.controllers;

import java.sql.SQLException;

import com.example.App;
import com.example.models.Livro;
import com.example.repositories.LivroRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RemoverController {
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

    @FXML
    private Button voltar;//

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

     // Método para excluir aluno selecionado
    @FXML
    private void remover(ActionEvent event) 
    {
        Livro livroSelecionado = tableView.getSelectionModel().getSelectedItem();
        if (livroSelecionado != null) 
        {
            try {
                excluir(livroSelecionado); //exclui no banco de dados
                
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText("ERRO");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
            
            // Remove o aluno da ListView
            tableView.getItems().remove(livroSelecionado);

           
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Livro excluído");
            alert.setContentText("O livro " + livroSelecionado.getNome() + " foi excluído com sucesso.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Atenção");
            alert.setHeaderText("Nenhum livro selecionado");
            alert.setContentText("Por favor, selecione um livro para excluir.");
            alert.showAndWait();
        }
    }

    private void excluir(Livro livro) throws SQLException{
        repository =  new LivroRepository();
        repository.excluir(livro);
    }
   
}