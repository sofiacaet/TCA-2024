package com.example.DAO;

import java.sql.*;
import java.util.ArrayList;

import com.example.db.FabricaConexoes;
import com.example.models.Livro;
import com.example.models.enums.Status;
import com.example.models.interfaces.LivroDAO;

public class LivroDAOImpl implements LivroDAO {
    @Override
    public void adicionar(Livro livro) {
        String sql = "INSERT INTO Estoque_Livro (id, nome, quantidade, categoria, preco) VALUES (?, ?, ?, ?, ?)";
        try (
            Connection conexao = FabricaConexoes.getInstance().getConnection(); 
            PreparedStatement stmt = conexao.prepareStatement(sql)
        ) {
            stmt.setString(1, livro.getIdLivro());
            stmt.setString(2, livro.getNome());
            stmt.setInt(3, livro.getQuantidade());
            stmt.setString(4, livro.getCategoria());
            stmt.setDouble(5, livro.getPreco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Livro livro) {
        String sql = "UPDATE Estoque_Livro SET quantidade = ?, preco = ? WHERE id = ?";
        try (
            Connection conexao = FabricaConexoes.getInstance().getConnection(); 
            PreparedStatement stmt = conexao.prepareStatement(sql)
        ) {
            stmt.setInt(1, livro.getQuantidade());
            stmt.setDouble(2, livro.getPreco());
            stmt.setString(3, livro.getIdLivro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Livro livro) {
        String sql = "UPDATE Estoque_Livro SET status='indisponivel' WHERE id = ?";
        try (
            Connection conexao = FabricaConexoes.getInstance().getConnection(); 
            PreparedStatement stmt = conexao.prepareStatement(sql)
        ) {
            stmt.setString(1, livro.getIdLivro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Livro buscarId(String id) {
        String sql = "SELECT * FROM Estoque_Livro WHERE id = ?";
        try (
            Connection conexao = FabricaConexoes.getInstance().getConnection(); 
            PreparedStatement stmt = conexao.prepareStatement(sql)
        ) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Livro(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getString("categoria"),
                        rs.getDouble("preco"),
                        Status.fromString(rs.getString("status"))
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Livro> listar() {
        String sql = "SELECT * FROM Estoque_Livro";
        ArrayList<Livro> livros = new ArrayList<>();
        try (
            Connection conexao = FabricaConexoes.getInstance().getConnection(); 
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                if (rs.getString("status").equals("disponivel para venda")) {
                    livros.add(new Livro(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getString("categoria"),
                        rs.getDouble("preco"),
                        Status.fromString(rs.getString("status")
                    )));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return livros;
    }
}