package com.example.models.interfaces;

import com.example.models.Usuario;

public interface UsuarioDAO 
{
    public Usuario buscarPorEmail(String email);
    public void cadastrar(Usuario usuario);

}
