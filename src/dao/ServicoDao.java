
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

import conexao.ConnectionFactory;
import java.util.ArrayList;
import models.Servico;

public class ServicoDao {
    public void create(Servico s) throws SQLException{
        //criando uma instancia da conexao
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;

        try{
            sql = con.prepareStatement("insert into servico(descricao,valor) values(?,?)");
            sql.setString(1, s.getDescricao());
            sql.setFloat(2,s.getValor());

            sql.executeUpdate();
            JOptionPane.showMessageDialog(null,"cadastrado com sucesso");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Cadastrar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con,sql);
        }
    }
    
   public List <Servico> read() throws SQLException {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement sql = null;
    ResultSet rs = null;
       
    List<Servico> servicos = new ArrayList<>();
    
    try{ sql = con.prepareStatement("Select * from servico");
    rs = sql.executeQuery();
    
    while(rs.next()){
        //instaciação de um objeto
        Servico servico = new Servico();
        
        servico.setId(rs.getInt("id"));
        servico.setDescricao(rs.getString("descricao"));
        servico.setValor(rs.getFloat("valor"));
        servicos.add(servico);
    }
    
    }catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Erro ao acessar o Banco de dados: " + ex);
    }finally{
        ConnectionFactory.closeConnection(con,sql,rs);
    }
    return servicos;
}
   public void update(Servico s) throws SQLException{
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement sql = null;
       
       try{
           sql = con.prepareStatement("update servico set descricao = ?, valor = ? where id = ?");
           sql.setString(1,s.getDescricao());
           sql.setFloat(2, s.getValor());
           sql.setInt(3, s.getId());
           
           sql.executeUpdate();
           
           JOptionPane.showMessageDialog(
           null,"Dados Atualizados com Sucesso!");
           
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(
           null,"Erro ao Atualizar" + ex);
           
       }finally{
           ConnectionFactory.closeConnection(con,sql);
       }
       
   }
   public void delete(Servico s) throws SQLException{
         Connection con = ConnectionFactory.getConnection();
       PreparedStatement sql = null;
       
       try{
           sql = con.prepareStatement("DELETE FROM servico WHERE id = ?");
           sql.setInt(1, s.getId());
           
           sql.executeUpdate();
           
           JOptionPane.showMessageDialog(
           null,"Excluido com Sucesso!");
           
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(
           null,"Falha ao Excluir" + ex);
           
       }finally{
           ConnectionFactory.closeConnection(con,sql);
       }
       
      
       
   }
   public List<Servico> readBusca(String busca) throws SQLException{
       
        Connection con = ConnectionFactory.getConnection();
    PreparedStatement sql = null;
    ResultSet rs = null;
       
    List<Servico> servicos = new ArrayList<>();
    
    try{ sql = con.prepareStatement("Select * from servico where descricao like ?");
    sql.setString(1, "%" + busca + "%");
    rs = sql.executeQuery();
    
    while(rs.next()){
        //instaciação de um objeto
        Servico servico = new Servico();
        
        servico.setId(rs.getInt("id"));
        servico.setDescricao(rs.getString("descricao"));
        servico.setValor(rs.getFloat("valor"));
        servicos.add(servico);
    }
    
    }catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Erro ao acessar o Banco de dados: " + ex);
    }finally{
        ConnectionFactory.closeConnection(con,sql,rs);
    }
    return servicos;
   }
}
