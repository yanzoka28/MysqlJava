package dao;

import domain.Pessoa;

import java.sql.SQLException;

public class AppDao {

    public static void main(String[] args) throws SQLException {


        var pessoaDAO = new PessoaDAO();
        var maria = new Pessoa("Maria", "12312345");
        var jose = new Pessoa("Jose", "14478545");

    pessoaDAO.savePessoa(maria);
    pessoaDAO.savePessoa(jose);



       pessoaDAO.getAll().forEach(p -> System.out.println(p));
    }
}
