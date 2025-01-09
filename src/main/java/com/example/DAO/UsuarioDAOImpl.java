package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import com.example.db.FabricaConexoes;
import com.example.models.Usuario;
import com.example.models.interfaces.UsuarioDAO;

public class UsuarioDAOImpl implements UsuarioDAO
{
    private Connection conexao;
    
    public UsuarioDAOImpl () throws SQLException{
        this.conexao = FabricaConexoes.getInstance().getConnection();
    }

    @Override
    public Usuario bucarPorEmail(String email) 
    {

        Usuario usuario = null;
        String sql = "select * FROM Estoque_Usuario WHERE email = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                usuario =  new Usuario();
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha_hash(rs.getString("senha_hash"));
            }

            rs.close();

            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }
    
}
