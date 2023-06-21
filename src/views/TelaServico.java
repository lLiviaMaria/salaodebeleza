
package views;
import dao.ServicoDao;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Servico;

public class TelaServico extends javax.swing.JFrame {

 
    public TelaServico() throws SQLException {
        initComponents();
        setIcon();
        txtDescricao.grabFocus();
        readJTable(); 
        
    }
    
    private void setIcon(){
      setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../imagens/cut.png")));
}
    public void readJTable() throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) tblServico.getModel();
        tblServico.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0); //evita a duplicação de dados da view na tabela
       
        ServicoDao servicoDao = new ServicoDao();
        
         for( Servico servico: servicoDao.read()){
            modelo.addRow(new Object[]{
                servico.getId(),
                servico.getDescricao(),
                servico.getValor()
            
            });
        }
    }
    
    
      public void selecionarItem(){
         if(tblServico.getSelectedRow()!= -1){
       txtId.setText(tblServico.getValueAt(tblServico.getSelectedRow(), 0).toString());
       txtDescricao.setText(tblServico.getValueAt(tblServico.getSelectedRow(), 1).toString());
       txtValor.setText(tblServico.getValueAt(tblServico.getSelectedRow(), 2).toString());
       
       //habilitar os botões
       btnExcluir.setEnabled(true);
       btnAtualizar.setEnabled(true);
       
       //desabilitar os botões
       btnAdicionar.setEnabled(false);
       btnBusca.setEnabled(false);
       txtBusca.setEnabled(false);
     }else{
         JOptionPane.showMessageDialog(null,"Selecione um Serviço!");
     }
    }
        public void readJTableBusca(String busca) throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) tblServico.getModel();
        tblServico.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0); //evita a duplicação de dados da view na tabela
       
        ServicoDao servicoDao = new ServicoDao();
        
         for( Servico servico: servicoDao.readBusca(busca)){
            modelo.addRow(new Object[]{
                servico.getId(),
                servico.getDescricao(),
                servico.getValor()
            
            });
        }
    }
    
    public void limpar () throws SQLException{
        txtId.setText("");
        txtDescricao.setText("");
        txtValor.setText("");
        txtBusca.setText("");
        //levando o foco do cursor para o primeiro campo
        txtDescricao.grabFocus();
        //Desabilitar os botões editar e excluir 
        btnExcluir.setEnabled(false);
        btnAtualizar.setEnabled(false);
    
   // habilitar os botões adicionar e buscar
     btnAdicionar.setEnabled(true);
     btnBusca.setEnabled(true);
     txtBusca.setEnabled(true);
    //listar os dados da tabela
      readJTable();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServico = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        txtValor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        btnBusca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Serviços");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 110, 30));

        tblServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServicoMouseClicked(evt);
            }
        });
        tblServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblServicoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblServico);
        if (tblServico.getColumnModel().getColumnCount() > 0) {
            tblServico.getColumnModel().getColumn(0).setHeaderValue("ID");
            tblServico.getColumnModel().getColumn(1).setHeaderValue("Descrição");
            tblServico.getColumnModel().getColumn(2).setHeaderValue("Valor");
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 630, 110));

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/house_go.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        jPanel1.add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 110, 30));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pencil.png"))); // NOI18N
        btnAtualizar.setText(" Atualizar");
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 110, 30));

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/limpar.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 110, 30));

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 110, 30));
        jPanel1.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 250, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setText("Descrição");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 120, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setText("Valor");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 50, 30));
        jPanel1.add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 210, 30));

        txtId.setEnabled(false);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 40, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setText("ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 30, 30));

        txtBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaActionPerformed(evt);
            }
        });
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaKeyPressed(evt);
            }
        });
        jPanel1.add(txtBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 200, 30));

        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/zoom.png"))); // NOI18N
        btnBusca.setText("Buscar");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });
        jPanel1.add(btnBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 110, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/transparencia.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 720, 450));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoInterno.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        try {
            readJTableBusca(txtBusca.getText());
        } catch (SQLException ex) {
           System.out.println("Erro na Busca" + ex);
        }
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
     if(tblServico.getSelectedRow() != -1){
         int resp = JOptionPane.showConfirmDialog(null,"Confirma a exclusão?", "Exclusão de campo", OK_CANCEL_OPTION);
     
        if(resp == 0){
        Servico servico = new Servico();
        ServicoDao dao = new ServicoDao();
        servico.setId ((int) tblServico.getValueAt(tblServico.getSelectedRow(), 0));
        
             try {
                 dao.delete(servico);
             } catch (SQLException ex) {
                 Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
             }                 
             try {
                 limpar();
             } catch (SQLException ex) {
                 Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
             }
    }else{
          JOptionPane.showMessageDialog(null, "Informe a descrição e o valor do serviço");
            }
     
    }//GEN-LAST:event_btnExcluirActionPerformed
    }
    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        try {
            limpar();
        } catch (SQLException ex) {
            Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
     TelaServico.this.dispose();      
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
if(tblServico.getSelectedRow()!= -1){
   //cria os objeto Servico e ServicoDao
    Servico servico = new Servico();
    ServicoDao dao = new ServicoDao();
    
    //seta (modifica) os campos do objeto servico 
    servico.setDescricao(txtDescricao.getText());
    servico.setValor(Float.parseFloat(txtValor.getText()));
    servico.setId((int)tblServico.getValueAt(tblServico.getSelectedRow(), 0));
    
    try {
        //atualiza o banco de daods
        dao.update(servico);
    } catch (SQLException ex) {
        Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        //limpa os campos e atualiza a tabela
        limpar();
    } catch (SQLException ex) {
        Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
    }
    
            
    
}
    
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyPressed
        try {
            readJTableBusca(txtBusca.getText());
        } catch (SQLException ex) {
           System.out.println("Erro na Busca" + ex);
        }
    }//GEN-LAST:event_txtBuscaKeyPressed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
    if(!txtValor.getText().isEmpty() && !txtDescricao.getText().isEmpty()){
        
        //instancia os objetos servico e dao
        Servico servico = new Servico();
        ServicoDao dao = new ServicoDao();
        
        //seta os campos da tabela
        servico.setDescricao(txtDescricao.getText());
        servico.setValor(Float.parseFloat(txtValor.getText()));
        try {
            dao.create(servico);
        } catch (SQLException ex) {
            System.out.println("Erro ao acessar o banco de daods." + "Entre em contato com o administrador do sistema" + ex);
        }
        try {
            limpar();
        } catch (SQLException ex) {
              System.out.println("Erro ao acessar o banco de daods." + "Entre em contato com o administrador do sistema" + ex);
        }
    }else{
        JOptionPane.showMessageDialog(null, "Informe a descrição e o valor do serviço");
        txtDescricao.grabFocus();
    }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void tblServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServicoMouseClicked
  selecionarItem();  
     
    }//GEN-LAST:event_tblServicoMouseClicked

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void tblServicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblServicoKeyReleased
     selecionarItem();    }//GEN-LAST:event_tblServicoKeyReleased

      public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaServico().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblServico;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
