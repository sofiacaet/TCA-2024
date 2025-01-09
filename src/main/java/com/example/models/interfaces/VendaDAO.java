package com.example.models.interfaces;

import java.util.ArrayList;

import com.example.models.Venda;

public interface VendaDAO 
{
    public void registrar(Venda venda);

    public Venda buscarId(String id);
    
    public ArrayList<Venda> listar();
}