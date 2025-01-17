package com.example.models.interfaces;

import com.example.models.Cliente;

public interface ClienteDAO 
{
    public void cadastrar(Cliente cliente);
    public Cliente buscarPorCpf(String cpf);
}
