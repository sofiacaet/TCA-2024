package com.example.models;

import com.example.utils.Hash;

public class Usuario 
{
    private String email;
    private String senha_hash;
    
    public Usuario() {
    }

    public Usuario(String email, String senha) 
    {
        this.email = email;
        this.senha_hash = Hash.generateHash(senha, "SHA-256");
    }
   
    public String getEmail() 
    {
        return email;
    }
    
    public void setEmail(String email) 
    {
        this.email = email;
    }
    
    public String getSenha_hash() 
    {
        return senha_hash;
    }
   
    public void setSenha_hash(String senha_hash) 
    {
        this.senha_hash = senha_hash;
    }
}
