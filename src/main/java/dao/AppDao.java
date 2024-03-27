package dao;

import domain.Pessoa;

public class AppDao {

    public static void main(String[] args){

        var pessoaDAO = new PessoaDAO();

        var Maria = new Pessoa("Maria", "12312345");
        var Jose = new Pessoa("Jose", "14478545");

    pessoaDAO.savePessoa(Maria);
    pessoaDAO.savePessoa(Jose);


    }
}
