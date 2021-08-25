package br.com.conexaojdbc;

import br.com.conexaojdbc.model.dao.AnimalDAO;
import br.com.conexaojdbc.model.dao.ProdutoDAO;
import br.com.conexaojdbc.model.entity.Animal;
import br.com.conexaojdbc.model.entity.Produto;

import java.sql.SQLException;
import java.util.List;

public class Server3 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Produto p = new Produto("Televisao", 1188, 8999.00, 9,
                                "Eletronico", true);

        ProdutoDAO dao = new ProdutoDAO();

        dao.save(p);

        ProdutoDAO daoLista = new ProdutoDAO();
        List<Produto> produtos = daoLista.findAll();

        for (Produto itemList: produtos) {
            System.out.println(itemList);
        }

        System.out.println("--- Nova Lista ---");

        ProdutoDAO daoAlteracao = new ProdutoDAO();
        daoAlteracao.update("Notebook", 3);

        ProdutoDAO daoListaNova = new ProdutoDAO();
        List<Produto> produtoNovo = daoListaNova.findAll();

        for (Produto itemListNovo: produtoNovo) {
            System.out.println(itemListNovo);
        }
        
        System.out.println("--- Teste de Delete ---");

        ProdutoDAO daoDelete = new ProdutoDAO();
        daoDelete.delete(4);

        ProdutoDAO daoListaDelete = new ProdutoDAO();
        List<Produto> produtoDelete = daoListaDelete.findAll();

        for (Produto itemListDelete: produtoDelete) {
            System.out.println(itemListDelete);
        }

    }
}
