package com.example.models;


public class Cliente 
{
    private String nome;
    private String cpf;
    private String numero;
   
   
    public Cliente() 
    {
        
    }


    public Cliente(String nome, String cpf, String numero) throws Exception
    {
        this.validacao(nome, cpf, numero); //se ele não passar por essa linha ele não constroi 
        this.nome = nome;
        this.cpf = cpf;
        this.numero = numero;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) throws Exception {
        this.validacao(nome, this.cpf, this.numero);
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) throws Exception {
        this.validacao(this.nome, cpf, this.numero);
        this.cpf = cpf;
    }


    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) throws Exception {
        this.validacao(this.nome, this.cpf, numero);
        this.numero = numero;
    }

    private void validacao(String nome, String cpf, String telefone) throws Exception 
    {
        // Validação do nome
        if (nome.length() < 3 || nome.length() > 50) 
        {
            throw new Exception("ERRO: O nome do cliente deve ter mais que 3 caracteres e menos que 50!");
        }

        // Validação do CPF (deve conter 11 dígitos numéricos)
        if (cpf.length() != 11 || !cpf.matches("\\d{11}")) 
        {
            throw new Exception("ERRO: CPF inválido. O CPF deve ter 11 dígitos numéricos.");
        }

        // Validação do telefone (deve conter 11 dígitos numéricos, com DDD)
        if (telefone.length() != 11 || !telefone.matches("\\d{11}")) 
        {
            throw new Exception("ERRO: Número de telefone inválido. O telefone deve ter 11 dígitos numéricos com DDD.");
        }
    }

}