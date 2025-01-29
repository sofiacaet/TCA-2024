package com.example.controllers;

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
import javafx.scene.control.TextInputDialog;

public class EditarController 
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

    @FXML
    private Button voltar;//

    @FXML
    private Button editar;//

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
        try 
        {
            App.setRoot("telaInicial");
        } catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
    }
    

    // Método para editar livro selecionado
    @FXML
    private void editar(ActionEvent event)
    {
        Livro livroSelecionado= tableView.getSelectionModel().getSelectedItem();
        if (livroSelecionado != null) 
        {
            // Exibe um diálogo para editar os dados do aluno
            TextInputDialog dialog = new TextInputDialog(livroSelecionado.getPreco().toString());
            dialog.setTitle("Editar Livro");
            dialog.setHeaderText("Edite os dados do livro.");
            dialog.setContentText("Preço:");


            dialog.showAndWait().ifPresent(novoPreco -> 
            {
                // Atualiza o aluno na TableView
                int index = tableView.getSelectionModel().getSelectedIndex();
                tableView.getItems().set(index, livroSelecionado);

                // Atualiza o arquivo txt
                try 
                {
                    livroSelecionado.setPreco(Double.parseDouble(novoPreco)); //parseDouble transformando a string em double
                    atualizarLivro(livroSelecionado);
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);   
                    alert.setTitle("ERRO");
                    alert.setHeaderText("ERRO!");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucesso!");
                alert.setHeaderText("Livro editado.");
                alert.setContentText("O livro foi editado com sucesso.");
                alert.showAndWait();
            });
        } else 
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Nenhum livro selecionado.");
            alert.setContentText("Por favor, selecione um livro para editar.");
            alert.showAndWait();
        }
    }


    private void atualizarLivro(Livro livro) throws Exception
    {
        repository = new LivroRepository();
        repository.editar(livro);
    }
}