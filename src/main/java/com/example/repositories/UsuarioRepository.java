package com.example.repositories;

import java.sql.SQLException;

import com.example.DAO.UsuarioDAOImpl;
import com.example.models.Usuario;

public class UsuarioRepository 
{
    UsuarioDAOImpl usuarioDAOImpl;

    public UsuarioRepository() throws SQLException 
    {
        this.usuarioDAOImpl = new UsuarioDAOImpl();
    }

    public Usuario buscarPorEmail(String email) throws SQLException 
    {
        
       return usuarioDAOImpl.buscarPorEmail(email);
    }

    public void cadastrar(Usuario usuario) throws SQLException 
    {
        
       usuarioDAOImpl.cadastrar(usuario);
    }

}
