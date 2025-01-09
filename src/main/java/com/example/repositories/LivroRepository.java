package com.example.repositories;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.DAO.LivroDAOImpl;
import com.example.models.Livro;

public class LivroRepository {
    LivroDAOImpl livroDAOImpl;

    public LivroRepository() throws SQLException
    {
        this.livroDAOImpl = new LivroDAOImpl();
    }

    public void adicionar(Livro livro)
    {
        livroDAOImpl.adicionar(livro);
    }
    
    public void editar(Livro livro)
    {
        livroDAOImpl.editar(livro);
    }

    public void excluir(Livro livro)
    {
        livroDAOImpl.excluir(livro);
    }

    public Livro buscarId(String id)
    {
        return livroDAOImpl.buscarId(id);
    }

    public ArrayList<Livro> listar()
    {
        return livroDAOImpl.listar();
    }
    
}
