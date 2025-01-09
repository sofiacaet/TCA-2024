package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.db.FabricaConexoes;
import com.example.models.Aluno;
import com.example.models.interfaces.AlunoDAO;

public class AlunoDAOImpl implements AlunoDAO {
    private Connection conexao;

    public AlunoDAOImpl() throws SQLException {
        this.conexao = FabricaConexoes.getInstance().getConnection();
    }

    @Override
    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, email) VALUES (?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void alterar(Aluno aluno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    @Override
    public void editar(Aluno aluno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editar'");
    }

    @Override
    public void excluir(Aluno aluno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    @Override
    public void getAlunos() {
        String sql = "SELECT * FROM aluno";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                System.out.println(result.getString("nome"));
            }
            stmt.close();

            result.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
