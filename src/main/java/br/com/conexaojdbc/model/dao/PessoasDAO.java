package br.com.conexaojdbc.model.dao;

import br.com.conexaojdbc.model.data.Conexao;
import br.com.conexaojdbc.model.entity.Pessoas;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoasDAO {

    private Conexao conexao = null;

    public PessoasDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new Conexao();
    }

    public void save(Pessoas pessoas) throws SQLException {
        String statement = "INSERT INTO pessoas(nome, idade, cpf, endereco) values(?, ?, ?, ?)";

        try(PreparedStatement pstmt = this.conexao.getConnection().prepareStatement(statement)){
            pstmt.setString(1, pessoas.getNome());
            pstmt.setInt(2, pessoas.getIdade());
            pstmt.setString(3, pessoas.getCpf());
            pstmt.setString(4, pessoas.getEndereco());

            pstmt.execute();
            this.conexao.commit();

        } catch (SQLException e){
            this.conexao.rollback();
            throw e;
        }
    }
}
