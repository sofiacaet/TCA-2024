package com.example.DAO;

import java.sql.*;
import java.util.ArrayList;

import com.example.db.FabricaConexoes;
import com.example.models.Livro;
import com.example.models.interfaces.LivroDAO;

public class LivroDAOImpl implements LivroDAO {
    private Connection conexao;

    public LivroDAOImpl() throws SQLException {
        this.conexao = FabricaConexoes.getInstance().getConnection();
    }

    @Override
    public void adicionar(Livro livro) {
        String sql = "INSERT INTO Estoque_Livro (id, nome, quantidade, categoria, preco) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
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
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
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
        String sql = "DELETE FROM Estoque_Livro WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, livro.getIdLivro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Livro buscarId(String id) {
        String sql = "SELECT * FROM Estoque_Livro WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Livro(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getString("categoria"),
                        rs.getDouble("preco")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Livro> listar() {
        String sql = "SELECT * FROM livros";
        ArrayList<Livro> livros = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                livros.add(new Livro(
                    rs.getString("id"),
                    rs.getString("nome"),
                    rs.getInt("quantidade"),
                    rs.getString("categoria"),
                    rs.getDouble("preco")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }
}