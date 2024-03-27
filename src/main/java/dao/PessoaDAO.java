package dao;

import connection.ConnectionMySQL;
import domain.Pessoa;

import java.sql.Connection;
import java.sql.SQLException;

public class PessoaDAO {

    private Connection connection;

    public PessoaDAO(){
        this.connection = ConnectionMySQL.getConnection();
    }

    public void savePessoa(Pessoa pessoa){
        String sql = "INSERT INTO PESSOA(nome, cpf) valures (?, ?)";

        try{
            var smt = connection.prepareStatement(sql);
            smt.setString(1, pessoa.getNome());
            smt.setString(2, pessoa.getCpf());
            smt.execute(sql);
            System.out.println("Operecao executada com sucesso");
    }catch (SQLException ex){
            System.err.println("operacao falha" + ex.getMessage());
        }
    }
}
