package br.com.conexaojdbc.model.dao;

import br.com.conexaojdbc.model.data.Conexao;
import br.com.conexaojdbc.model.entity.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Conexao conexao = null;

    public ProdutoDAO() throws SQLException, ClassNotFoundException{
        this.conexao = new Conexao();
    }

    // CREATE:
    public void save(Produto produto) throws SQLException {
        String statement = "INSERT INTO produto(nome, codigo, preco, quantidade, tipo, ativo) " +
                           "values(?, ?, ?, ?, ?, ?)";

        try(PreparedStatement pstmt = this.conexao.getConnection().prepareStatement(statement)){
            pstmt.setString(1, produto.getNome());
            pstmt.setInt(2, produto.getCodigo());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setInt(4, produto.getQuantidade());
            pstmt.setString(5,produto.getTipo());
            pstmt.setBoolean(6, produto.isAtivo());
            pstmt.execute();
            this.conexao.commit();

        } catch (SQLException e){
            this.conexao.rollback();
            throw e;
        }
    }

    // READ - FindAll:
    public List<Produto> findAll() throws SQLException{
        String statement = "SELECT id, nome, codigo, preco, quantidade, tipo, ativo from produto";

        try(PreparedStatement pstmt = this.conexao.getConnection().prepareStatement(statement)){
            ResultSet resultSet = pstmt.executeQuery();

            List<Produto> produtoList = new ArrayList<>();

            while (resultSet.next()){
                Produto produtoBuscado = new Produto(resultSet.getString("nome"),
                                                     resultSet.getInt("codigo"),
                                                     resultSet.getDouble("preco"),
                                                     resultSet.getInt("quantidade"),
                                                     resultSet.getString("tipo"),
                                                     resultSet.getBoolean("ativo"));
                produtoList.add(produtoBuscado);
            }
            return produtoList;

        } catch (SQLException e){
            this.conexao.rollback();
            throw e;
        }
    }

    // READ - FindBy:



    // UPDATE:
    public void update(String nomeAlterado, int id) throws SQLException {
        String statement = "UPDATE produto set nome = ? where id = ?";

        try(PreparedStatement pstmt = this.conexao.getConnection().prepareStatement(statement)){
            pstmt.setString(1, nomeAlterado);
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }

    // DELETE:
    public void delete(int id) throws SQLException {
        String statement = "DELETE from produto where id = ?";

        try(PreparedStatement pstmt = this.conexao.getConnection().prepareStatement(statement)){
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }
}
