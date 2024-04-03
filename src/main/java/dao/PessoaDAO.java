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
    public  Pessoa findByCPF(String cpf) {
        String sql = "SELECT * FROM pessoa WHERE cpf = ?";

        try {
            var stm = connection.prepareStatement(sql);
            stm.setString(1, cpf);
            var rs = stm.executeQuery();
            var pessoa = new Pessoa();
            if(rs.next()){
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setId(rs.getLong("id"));
            }
                return pessoa;
        } catch (SQLException e){
            System.out.println("erro ao executar consulta para o cpf: " + cpf);

        }
        System.out.println("erro ao executar consulta para o cpf: " + cpf);
        return new Pessoa();
    }

    public void updatePessoa(Pessoa pessoa) throws SQLException{
        String sql = "UPDATE PESSOA SET NOME = ?, CPF = ? WHERE ID = ?";
        var stmt = connection.prepareStatement(sql);
        stmt.setObject(1, pessoa.getNome());
        stmt.setObject(2, pessoa.getCpf());
        stmt.setObject(3, pessoa.getId());
        stmt.executeUpdate();
    }

    public void deletePessoa(Long id) throws  SQLException{
        var sql = "DELETE FROM PESSOA WHERE ID = ?";
        var stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.execute();
        System.out.println("usuario removido com sucesso");
    }
}
