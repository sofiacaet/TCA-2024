package com.example.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import com.example.App;
import com.example.models.Livro;
import com.example.models.Venda;
import com.example.repositories.LivroRepository;
import com.example.repositories.VendaRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TransacoesController 
{
    @FXML
    private TableView<Venda> tableView;

    @FXML
    private TableColumn<Venda, String>  cpfCliente;

    @FXML
    private TableColumn<Venda, String>  nomeLivro;

    @FXML
    private TableColumn<Venda, Integer>  quantidade;

    @FXML
    private TableColumn<Venda, Double>  valorTotal;

    @FXML
    private TableColumn<Venda, LocalDate>  dataVenda;

    private final ObservableList<Venda> transacoes = FXCollections.observableArrayList();
     
    private VendaRepository repository ;

    @FXML
    public void initialize() throws Exception
    {
        cpfCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        nomeLivro.setCellValueFactory(new PropertyValueFactory<>("nomeLivro"));
        quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidadeVendida"));
        valorTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        dataVenda.setCellValueFactory(new PropertyValueFactory<>("dataVenda"));

        repository = new VendaRepository();
     
        transacoes.addAll(repository.listar());

        tableView.setItems(transacoes);
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
