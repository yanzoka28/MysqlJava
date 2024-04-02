package dao;

import connection.ConnectionMySQL;
import domain.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private Connection connection;
    private PreparedStatement stml;

    public PessoaDAO(){
        this.connection = ConnectionMySQL.getConnection();
    }

    public void savePessoa(Pessoa pessoa){
        String sql = "INSERT INTO PESSOA(nome, cpf) values (?, ?)";

        try{
            var smt = connection.prepareStatement(sql);
            smt.setString(1, pessoa.getNome());
            smt.setString(2, pessoa.getCpf());
            smt.execute();
            System.out.println("Operecao executada com sucesso");
    }catch (SQLException ex){
            System.err.println("operacao falha" + ex.getMessage());
        }
    }
    public List<Pessoa> getAll() throws SQLException{
        var pessoas = new ArrayList<Pessoa>();
        String sql = "SELECT * FROM PESSOA";

        var stmt = connection.prepareStatement(sql);
        var resultSet = stmt.executeQuery();

        while(resultSet.next()){
            var pessoa = new Pessoa(resultSet.getLong("id"), resultSet.getString("nome"), resultSet.getString("cpf")
            );
            pessoas.add(pessoa);
        }
        return pessoas;
    }
}
