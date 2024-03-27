package dml;

import connection.ConnectionMySQL;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateTable {

    private Connection connection;

    public CreateTable(){
        this.connection = ConnectionMySQL.getConnection();
    }
    public void createTablePessoa(){
        String sql;
        try {
            sql = "CREATE TABLE IF NOT EXISTS PESSOA (" +
                    "id int AUTO_INCREMENT , " +
                    "nome VARCHAR(255) NOT NULL, " +
                    "cpf VARCHAR(255) NOT NULL, " +
                    "PRIMARY KEY (id)" +
                    ")";


            var stmt = connection.prepareStatement(sql);
            stmt.execute();
            System.out.println("tabela pessoa criada com sucesso");
        }catch (SQLException ex){
            System.err.println("eroo ao criar tabela" + ex.getMessage());
        }



    }
}
