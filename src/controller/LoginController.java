   package controller;


import conexao.ConnectionFactory;
import views.TelaLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Usuario;
import views.TelaPrincipal;

public class LoginController { 
    private final TelaLogin viewLogin;

    public LoginController(TelaLogin viewLogin){
        this.viewLogin = viewLogin;
    } 

    public List<Usuario> loginSistema(String login, String senha) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        ResultSet rs = null;

        List <Usuario> usuarios = new ArrayList<>();

        try{ 
            sql = con.prepareStatement("Select * from usuario");
            rs = sql.executeQuery();

            while(rs.next()){
                String user = Integer.toString(rs.getInt("id"));
                String password = rs.getString("senha");
                if (login.equals(user) && senha.equals(password)){
                    this.viewLogin.dispose();
                    new TelaPrincipal().setVisible(true);
                    break;
                }
            }
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao realizar login" + ex);

        }finally{
            ConnectionFactory.closeConnection(con, sql, rs);
        }

        return usuarios;



    }
}