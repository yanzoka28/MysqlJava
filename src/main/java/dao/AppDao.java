package dao;

import domain.Pessoa;

import java.sql.SQLException;

public class AppDao {

    public static void main(String[] args) throws SQLException {


        var pessoaDAO = new PessoaDAO();
//        var maria = new Pessoa("Maria", "12312345");
//        var jose = new Pessoa("Jose", "14478545");
//
//    pessoaDAO.savePessoa(maria);
//    pessoaDAO.savePessoa(jose);
//
//
//
//       pessoaDAO.getAll().forEach(p -> System.out.println(p));
        var pessoa = pessoaDAO.findByCPF("12312345");
        System.out.println(pessoa);

//        var pessoa = new Pessoa();
//        pessoa.setId(1L);
//        pessoa.setNome("Armando");
//        pessoa.setCpf("0101021");
//        pessoaDAO.updatePessoa(pessoa);
//
//        pessoaDAO.getAll().forEach(p -> System.out.println(p));
//        System.out.println(pessoa);

//        pessoaDAO.deletePessoa(1l);
    }


}
