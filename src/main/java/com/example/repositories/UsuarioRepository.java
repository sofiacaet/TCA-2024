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

    public Usuario buscarPoEmail(String email) throws SQLException 
    {
        
       return usuarioDAOImpl.bucarPorEmail(email);
    }

}
