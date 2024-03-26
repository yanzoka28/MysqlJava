package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {

    //URL
    private static final String URL = "jdbc:mysql://localhost:3306/aulaJdbc";
    //Usuario
    private static final String USER = "root'@'%";
    //Senha
    private static final String PASSWORD = "1234";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("conexao realizada");
        }catch (SQLException ex){
            System.err.println("erro ao conectar a base da dados:" + ex.getMessage());
        }
        return connection;



    }
}
