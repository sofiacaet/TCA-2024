package com.example.controllers;

import com.example.App;
import com.example.models.Cliente;
import com.example.models.Livro;
import com.example.models.Venda;
import com.example.models.enums.Status;
import com.example.repositories.ClienteRepository;
import com.example.repositories.LivroRepository;
import com.example.repositories.VendaRepository;
import javafx.scene.control.Alert;

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
    ClienteRepository repositoryCliente;

    @FXML
    private void registrar()
    {
        try {
            repository = new VendaRepository();
            repositoryLivro = new LivroRepository();
            repositoryCliente = new ClienteRepository();

            Livro livro = repositoryLivro.buscarId(idLivro.getText());
            if (livro != null) {
                Cliente comprador = repositoryCliente.buscarPorCpf(cliente.getText());
                if (comprador != null) {
                    if (livro.getStatus() != Status.INDISPONIVEL) {
                        livro.vender(Integer.parseInt(quantidade.getText()));
                        Venda venda = new Venda(livro, Integer.parseInt(quantidade.getText()), cliente.getText());
                        repositoryLivro.editar(livro);
                        repository.registrar(venda);
                        App.setRoot("telaInicial");
                    }else{
                        throw new Exception("ERRO: Livro indisponivel para venda!");
                    }
                }else{
                    throw new Exception("ERRO: Cliente não cadastrado no sistema!");
                }
            }else{
                throw new Exception("ERRO: Livro não encontrado!");
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