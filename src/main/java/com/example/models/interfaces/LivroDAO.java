package com.example.models.interfaces;

import java.util.ArrayList;

import com.example.models.Livro;

public interface LivroDAO 
{
    public void adicionar(Livro livro);

    public void editar(Livro livro);

    public void excluir(Livro livro);

    public Livro buscarId(String id);
    
    public ArrayList<Livro> listar();
}
