package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String DRIVER = 
            "org.apache.derby.jdbc.ClientDriver";
    private static final String URL = 
            "jdbc:derby://localhost:1527/sample";
    private static final String USER = "app";
    private static final String PASS = "app";
    
    public static Connection abreConexao(){
        try {
            //carrega o driver para a memória
            Class.forName(DRIVER); 

            //estabelece a conexao já retornando o Connection
            return 
              DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("SQLException");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception");
            System.out.println(e.getMessage());
        }
        
        //se chegar aqui é porque deu alguma exceção...
        return null;
    }
    
    /*
    public static void main(String[] args) {
        Conexao.abreConexao();
    }
    */
}