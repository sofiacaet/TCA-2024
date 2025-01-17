package com.example.DAO;

import java.sql.*;

import com.example.db.FabricaConexoes;
import com.example.models.Cliente;
import com.example.models.interfaces.ClienteDAO;

public class ClienteDAOImpl implements ClienteDAO
{
    private Connection conexao;

    public ClienteDAOImpl() throws SQLException
    {
        this.conexao = FabricaConexoes.getInstance().getConnection();
    }

    @Override
    public void cadastrar(Cliente cliente) 
    {
        String sql = "INSERT INTO Estoque_Cliente (cpf, nome, numero) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getNumero());
            stmt.executeUpdate();
            this.conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente buscarPorCpf(String cpf) 
    {
        
         String sql = "SELECT * FROM Estoque_Cliente WHERE cpf = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("numero")
                      
                    );
                }
            }
        this.conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
