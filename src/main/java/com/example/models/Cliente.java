package com.example.models;


public class Cliente 
{
    private String nome;
    private String cpf;
    private String numero;
   
   
    public Cliente() 
    {
        
    }


    public Cliente(String nome, String cpf, String numero) 
    {
        this.nome = nome;
        this.cpf = cpf;
        this.numero = numero;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }
}
