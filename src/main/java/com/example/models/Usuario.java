package com.example.models;

import com.example.utils.Hash;

public class Usuario 
{
    private String email;
    private String senha_hash;
    
    public Usuario() {
    }

    public Usuario(String email, String senha) throws Exception
    {
        this.validarEmail(email);
        this.email = email;
        this.validarSenha(senha);
        this.senha_hash = Hash.generateHash(senha, "SHA-256");
    }
   
    public String getEmail() 
    {
        return email;
    }
    
    public void setEmail(String email) throws Exception
    {
        this.validarEmail(email);
        this.email = email;
    }
    
    public String getSenha_hash() 
    {
        return senha_hash;
    }
   
    public void setSenha_hash(String senha_hash) throws Exception
    {
        this.senha_hash = senha_hash;
    }


    private void validarEmail(String email) throws Exception 
    {
        // Expressão regular para validar o formato do email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Verifica se o email corresponde à expressão regular
        if (!email.matches(emailRegex)) {
            throw new Exception("ERRO: Email inválido. O email deve estar no formato correto.");
        }

    }

    private void validarSenha(String senha) throws Exception 
    {
        // Verifica se a senha tem pelo menos 8 caracteres e no máximo 20
        if (senha.length() < 8 || senha.length() > 20) 
        {
            throw new Exception("ERRO: A senha deve ter entre 8 e 20 caracteres.");
        }

        // Verifica se a senha contém pelo menos uma letra maiúscula
        if (!senha.matches(".*[A-Z].*")) 
        {
            throw new Exception("ERRO: A senha deve conter pelo menos uma letra maiúscula.");
        }

        // Verifica se a senha contém pelo menos uma letra minúscula
        if (!senha.matches(".*[a-z].*")) 
        {
            throw new Exception("ERRO: A senha deve conter pelo menos uma letra minúscula.");
        }

        // Verifica se a senha contém pelo menos um número
        if (!senha.matches(".*\\d.*")) 
        {
            throw new Exception("ERRO: A senha deve conter pelo menos um número.");
        }

        // Verifica se a senha contém pelo menos um caractere especial
        if (!senha.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) 
        {
            throw new Exception("ERRO: A senha deve conter pelo menos um caractere especial.");
        }
    }

    @Override
    public String toString() {
        return "Usuario [email=" + email + ", senha_hash=" + senha_hash + "]";
    }
}