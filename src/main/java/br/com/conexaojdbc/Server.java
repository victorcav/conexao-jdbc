package br.com.conexaojdbc;

import br.com.conexaojdbc.model.dao.AnimalDAO;
import br.com.conexaojdbc.model.dao.PessoasDAO;
import br.com.conexaojdbc.model.entity.Animal;
import br.com.conexaojdbc.model.entity.Pessoas;

import java.sql.SQLException;
import java.util.List;

public class Server {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        /*
        Animal a = new Animal("Bolt", "Tigre", 12, "Macho");

        AnimalDAO dao = new AnimalDAO();

        dao.save(a);


        Pessoas p = new Pessoas("Arthur", 12, "222.222.222-22","Rua SC-3");

        PessoasDAO dao = new PessoasDAO();

        dao.save(p);
        */

        AnimalDAO daoLista = new AnimalDAO();
        List<Animal> animais = daoLista.findAll();

        for (Animal itemList: animais) {
            System.out.println(itemList);
        }

        /*
          System.out.println("--- Nova Lista ---");

        AnimalDAO daoAlteracao = new AnimalDAO();
        daoAlteracao.update("Nina", 1);

        AnimalDAO daoListaNova = new AnimalDAO();
        List<Animal> animaisNovo = daoListaNova.findAll();

        for (Animal itemListNovo: animaisNovo) {
            System.out.println(itemListNovo);
        }
        */


        System.out.println("--- Teste de Delete ---");

        AnimalDAO daoDelete = new AnimalDAO();
        daoDelete.delete(4);

        AnimalDAO daoListaDelete = new AnimalDAO();
        List<Animal> animaisDelete = daoListaDelete.findAll();

        for (Animal itemListDelete: animaisDelete) {
            System.out.println(itemListDelete);
        }

    }
}
