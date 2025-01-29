package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.db.FabricaConexoes;
import com.example.models.Usuario;
import com.example.models.interfaces.UsuarioDAO;

public class UsuarioDAOImpl implements UsuarioDAO
{
    @Override
    public Usuario buscarPorEmail(String email) 
    {

        Usuario usuario = null;
        String sql = "select * FROM Estoque_Usuario WHERE email = ?";

        try (
            Connection conexao = FabricaConexoes.getInstance().getConnection(); 
            PreparedStatement stmt = conexao.prepareStatement(sql);
        ) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                usuario =  new Usuario();
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha_hash(rs.getString("senha_hash"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public void cadastrar(Usuario usuario) {
        String sql = "INSERT INTO Estoque_Usuario (email, senha_hash) VALUES (?, ?)";
        try (
            Connection conexao = FabricaConexoes.getInstance().getConnection(); 
            PreparedStatement stmt = conexao.prepareStatement(sql);
        ) {
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha_hash());
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}