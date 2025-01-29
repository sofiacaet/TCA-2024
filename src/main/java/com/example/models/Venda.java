package com.example.models;

import java.time.LocalDate;
import java.util.UUID;

public class Venda 
{
    private String idVenda;
    private Livro livro;
    private Integer quantidadeVendida;
    private Double valorTotal;
    private String cliente;
    private LocalDate dataVenda;
    private String nomeLivro;
    
    
    public Venda(String idVenda, Livro livro, Integer quantidadeVendida, Double valorTotal, String cliente,
            LocalDate dataVenda) {
        this.idVenda = idVenda;
        this.livro = livro;
        this.quantidadeVendida = quantidadeVendida;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.nomeLivro = livro.getNome();
    }


    public Venda(Livro livro, Integer quantidadeVendida, String cliente) 
    {
        this.idVenda = UUID.randomUUID().toString(); //vai gerar um id unico que não repete
        this.livro = livro;
        this.quantidadeVendida = quantidadeVendida;
        this.valorTotal = livro.getPreco() * quantidadeVendida;
        this.cliente = cliente;
        this.dataVenda = LocalDate.now(); // pega a data atual   
        this.nomeLivro = livro.getNome();
    }


    public String getIdVenda() {
        return idVenda;
    }
    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }
   
    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(Integer quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
    
    public Double getValorTotal() 
    {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) 
    {
        this.valorTotal = valorTotal;
    }

    public String getCliente() 
    {
        return cliente;
    }

    public void setCliente(String cliente) 
    {
        this.cliente = cliente;
    }

    public LocalDate getDataVenda() 
    {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) 
    {
        this.dataVenda = dataVenda;
    }


    public Livro getLivro() 
    {
        return livro;
    }


    public void setLivro(Livro livro) 
    {
        this.livro = livro;
    }


    public String getNomeLivro() {
        return nomeLivro;
    }


    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }
    

    @Override
    public String toString() {
        return "Venda [nomeLivro=" + nomeLivro + "]";
    }
   
}
