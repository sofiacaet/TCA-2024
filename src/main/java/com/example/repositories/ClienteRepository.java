package com.example.repositories;

import java.sql.SQLException;

import com.example.DAO.ClienteDAOImpl;
import com.example.models.Cliente;


public class ClienteRepository 
{
    ClienteDAOImpl clienteDAOImpl;

    public ClienteRepository() throws SQLException 
    {
        this.clienteDAOImpl = new ClienteDAOImpl();
    }
    
    public void cadastrar(Cliente cliente) throws SQLException 
    {
        
       clienteDAOImpl.cadastrar(cliente);
    }
    
    public Cliente buscarPorCpf(String cpf) throws SQLException 
    {
        
       return clienteDAOImpl.buscarPorCpf(cpf);
    }


}
