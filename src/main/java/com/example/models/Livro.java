package com.example.models;

import com.example.models.enums.Status;

public class Livro 
{
    private String idLivro;
    private String nome;
    private Integer quantidade;
    private String categoria;
    private Double preco;
    private Status status;

   
    public Livro(String idLivro, String nome, Integer quantidade, String categoria, Double preco, Status status) throws Exception {
        this.validacao(nome, preco, idLivro);
        this.idLivro = idLivro;
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.preco = preco;
        this.status = status;
    }

    // public Livro(String nome, Integer quantidade, String categoria, Double preco) throws Exception {
    //     this.validacao(nome, preco);
    //     this.nome = nome;
    //     this.quantidade = quantidade;
    //     this.categoria = categoria;
    //     this.preco = preco;
    //     this.status = Status.DISPONIVEL_PRA_VENDA;
    // }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        this.validacao(nome, this.preco, this.idLivro);
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;

    }

    public void setPreco(Double preco) throws Exception {
        this.validacao(this.nome, preco, this.idLivro);
        this.preco = preco;
    }

    public String getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(String idLivro) {
        this.idLivro = idLivro;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void vender(Integer quantidade) throws Exception 
    {
        Integer novaQuantidade = this.quantidade - quantidade;
        if (novaQuantidade >= 0) {
            this.quantidade = this.quantidade - quantidade;
        }else{
            throw new Exception("ERRO: Não temos esta quantidade em estoque!");
        }
    }

    private void validacao(String nome, Double preco, String idLivro) throws Exception
    {
        if (nome.length() < 3 || nome.length() > 50) {
            throw new Exception("ERRO: O nome do livro de ter mais que 3 caracteres e menos 50!");
        }

        if (preco < 0) {
            throw new Exception("ERRO: Preço não pode ser negativo!");
        }

        if (idLivro.length() != 5) 
        {
            throw new Exception("ERRO: ISBN deve ter 5 digitos!");
        }
    }

    @Override
    public String toString() {
        return "Livro [idLivro=" + idLivro + ", nome=" + nome + ", quantidade=" + quantidade + ", categoria="
                + categoria + ", preco=" + preco + ", status=" + status + "]";
    }

}