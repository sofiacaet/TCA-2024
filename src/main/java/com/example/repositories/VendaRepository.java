package com.example.repositories;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.DAO.VendaDAOImpl;
import com.example.models.Venda;

public class VendaRepository 
{
    VendaDAOImpl vendaDAOImpl;

    public VendaRepository() throws SQLException 
    {
        this.vendaDAOImpl = new VendaDAOImpl();
    }

    public void registrar( Venda venda)
    {
        this.vendaDAOImpl.registrar( venda);
    }

    public ArrayList<Venda> listar()
    {
        return this.vendaDAOImpl.listar(); 
    }

    public Venda buscar( String id)
    {
        return this.vendaDAOImpl.buscarId(id);
    }
}
