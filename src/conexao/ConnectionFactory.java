package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionFactory {
    //declaração de variaveis
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/salao";
    private static final String USER = "root";
    private static final String PASS = "";
    
    //abrindo o banco de dados
    public static Connection getConnection() throws SQLException{
        
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection(URL, USER, PASS);
        
       
    }
    //fechando a conexão com o banco de dados
    public static void closeConnection(Connection con){
        try{
            if(con != null){
                con.close();
            }
        }catch(SQLException ex){
            throw new RuntimeException("Erro de conexão!", ex);
        }
    }
    //fechando a sql da conexao 
    
   public static void closeConnection(Connection con, PreparedStatement sql){
       closeConnection(con);
       try{
           if(sql != null){
               sql.close();
           
           }
       }catch (SQLException ex){
           throw new RuntimeException("Erro de conexao!", ex);
       }
   }  
   //fechando os resultado da conexao
   public static void closeConnection(Connection con, PreparedStatement sql, ResultSet rs){
       closeConnection(con,sql);
       try{
           if(rs != null){
               rs.close();
           }
           }catch(SQLException ex){
               throw new RuntimeException("Erro de conexao!", ex);
       }
   }
}             
