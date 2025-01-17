package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.example.db.FabricaConexoes;
import com.example.models.Livro;
import com.example.models.Venda;
import com.example.models.interfaces.VendaDAO;

public class VendaDAOImpl implements VendaDAO 
{
    private Connection conexao;

    public VendaDAOImpl() throws SQLException{
        this.conexao = FabricaConexoes.getInstance().getConnection(); 
    }

    @Override
    public void registrar(Venda venda) 
    {
        String sql = "INSERT INTO Estoque_Venda (id, idLivro, quantidadeVendida, valorTotal, cpfCliente, dataVenda) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, venda.getIdVenda());
            stmt.setString(2, venda.getLivro().getIdLivro());
            stmt.setInt(3, venda.getQuantidadeVendida());
            stmt.setDouble(4, venda.getValorTotal());
            stmt.setString(5, venda.getCliente());
            stmt.setObject(6, venda.getDataVenda());
            stmt.executeUpdate();
            this.conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Venda buscarId(String id) {
       
        String sql = "SELECT * FROM Estoque_Venda WHERE id = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) 
        {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) 
            {
                if (rs.next()) 
                {
                    LocalDate dataVenda = rs.getObject("dataVenda", LocalDate.class);
                    
                    return new Venda(
                        rs.getString("id"),
                        buscarLivro(rs.getString("idLivro")),
                        rs.getInt("quantidadeVendida"),
                        rs.getDouble("valorTotal"),
                        rs.getString("cpfCliente"),
                        dataVenda
                    );
                }
            }
        this.conexao.close();
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Venda> listar() 
    {
        String sql = "SELECT * FROM Estoque_Venda";
        ArrayList<Venda> venda = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                LocalDate dataVenda = rs.getObject("dataVenda", LocalDate.class);
                venda.add(new Venda(
                    rs.getString("id"),
                    buscarLivro(rs.getString("idLivro")),
                    rs.getInt("quantidadeVendida"),
                    rs.getDouble("valorTotal"),
                    rs.getString("cpfCliente"),
                    dataVenda
                ));
            }
        this.conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return venda;
      
    }


    public Livro buscarLivro(String id) {
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
        this.conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
