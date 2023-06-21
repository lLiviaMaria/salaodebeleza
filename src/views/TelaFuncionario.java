
package views;


import dao.FuncionarioDao;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import models.Funcionario;

public class TelaFuncionario extends javax.swing.JFrame {

    
    public TelaFuncionario() throws SQLException {
        initComponents();
         setIcon();
        txtNome.grabFocus();
        readJTable(); 
    }
 private void setIcon(){
      setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../imagens/user_gray.png")));
}
   
    @SuppressWarnings("unchecked")
     public void readJTable() throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) tblFuncionario.getModel();
        tblFuncionario.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0); //evita a duplicação de dados da view na tabela
       
        FuncionarioDao dao = new FuncionarioDao();
        
         for(Funcionario funcionario: dao.read()){
            modelo.addRow(new Object[]{
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getTelefone(),
                funcionario.getEmail(),
                funcionario.getRg(),
                funcionario.getCpf(),
                funcionario.getSalario()
            });
        }
  }
      public void selecionarItem(){
         if(tblFuncionario.getSelectedRow()!= -1){
       txtId.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 0).toString());
       txtNome.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 1).toString());
       txtTelefone.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 2).toString());
       txtEmail.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 3).toString());
       txtRg.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 4).toString());
       txtCpf.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 5).toString());
       txtSalario.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 6).toString());
      
       
       //habilitar os botões
       btnExcluir.setEnabled(true);
       btnAtualizar.setEnabled(true);
       
       //desabilitar os botões
       btnAdicionar.setEnabled(false);
       btnBuscar.setEnabled(false);
       txtBusca.setEnabled(false);
     }else{
         JOptionPane.showMessageDialog(null,"Selecione um Funcioonario!");
     }
   }
        public void readJTableBusca(String busca) throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) tblFuncionario.getModel();
        tblFuncionario.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0); //evita a duplicação de dados da view na tabela
       
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        
         for(Funcionario funcionario: funcionarioDao.readBusca(busca)){
            modelo.addRow(new Object[]{
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getTelefone(),
                funcionario.getEmail(),
                funcionario.getRg(),
                funcionario.getCpf(),
                funcionario.getSalario()
            
            });
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTelefone2 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        txtBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jaslas = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionario = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();
        txtRg = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        try {
            txtTelefone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funcionarios");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaKeyPressed(evt);
            }
        });
        jPanel1.add(txtBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 240, 30));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/zoom.png"))); // NOI18N
        btnBuscar.setText(" Pesquisar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 140, 30));

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 140, 30));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btnExcluir.setText(" Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 140, 30));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pencil.png"))); // NOI18N
        btnAtualizar.setText(" Atualizar");
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 140, 30));

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/limpar.png"))); // NOI18N
        btnLimpar.setText(" Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 140, 30));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 40, -1));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 460, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setText("ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setText("Nome");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        jaslas.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jaslas.setText("Salário");
        jPanel1.add(jaslas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));
        jPanel1.add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 210, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setText("Telefone");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setText("E-mail");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 390, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel9.setText("RG");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel10.setText("CPF");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 120, -1));

        tblFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "Email", "RG", "CPF", "Salário"
            }
        ));
        tblFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncionarioMouseClicked(evt);
            }
        });
        tblFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblFuncionarioKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblFuncionario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 690, 110));

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/house_go.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        jPanel1.add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, 140, 30));

        try {
            txtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtRg, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 100, -1));

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 130, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/transparencia.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 740, 460));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoInterno.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 public void limpar () throws SQLException{
        txtId.setText("");
        txtNome.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtRg.setText("");
        txtCpf.setText("");
        txtSalario.setText("");
        //levando o foco do cursor para o primeiro campo
        txtNome.grabFocus();
        //Desabilitar os botões editar e excluir 
        btnExcluir.setEnabled(false);
        btnAtualizar.setEnabled(false);
    
   // habilitar os botões adicionar e buscar
     btnAdicionar.setEnabled(true);
     btnBuscar.setEnabled(true);
     txtBusca.setEnabled(true);
    //listar os dados da tabela
      readJTable();
 }
    
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
if(!txtTelefone.getText().isEmpty() && !txtNome.getText().isEmpty()){
        
        //instancia os objetos servico e dao
        Funcionario funcionario = new Funcionario();
         FuncionarioDao funcionarioDao = new FuncionarioDao();        
        //seta os campos da tabela
        funcionario.setNome(txtNome.getText());
        funcionario.setTelefone(txtTelefone.getText());
        funcionario.setEmail(txtEmail.getText());
        funcionario.setRg(txtRg.getText());
        funcionario.setCpf(txtCpf.getText());
        funcionario.setSalario(Float.parseFloat(txtSalario.getText()));
        try {
            funcionarioDao.create(funcionario);
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
        txtNome.grabFocus();
    }
                                                
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
     TelaFuncionario.this.dispose();      
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
  try {
            limpar();
        } catch (SQLException ex) {
            Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
   try {
            readJTableBusca(txtBusca.getText());
        } catch (SQLException ex) {
           System.out.println("Erro na Busca" + ex);
        }    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
         if(tblFuncionario.getSelectedRow() != -1){
         int resp = JOptionPane.showConfirmDialog(null,"Confirma a exclusão?", "Exclusão de campo", OK_CANCEL_OPTION);
     
        if(resp == 0){
       Funcionario funcionario = new Funcionario();
        FuncionarioDao dao = new FuncionarioDao();
        funcionario.setId ((int) tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 0));
        
             try {
                 dao.delete(funcionario);
             } catch (SQLException ex) {
                 Logger.getLogger(TelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
             }                 
             try {
                 limpar();
             } catch (SQLException ex) {
                 Logger.getLogger(TelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
             }
    }else{
          JOptionPane.showMessageDialog(null, "Informe o nome e o telefone do cliente");
            }
     
    }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
    if(tblFuncionario.getSelectedRow()!= -1){
        //cria os objeto Servico e ServicoDao
        Funcionario funcionario = new Funcionario();
        FuncionarioDao dao = new FuncionarioDao();
        
    //seta (modifica) os campos do objeto servico 
    funcionario.setNome(txtNome.getText());
    funcionario.setTelefone(txtTelefone.getText());
    funcionario.setEmail(txtEmail.getText());
    funcionario.setRg(txtRg.getText());
    funcionario.setCpf(txtCpf.getText());
    funcionario.setSalario(Float.parseFloat(txtSalario.getText()));
    funcionario.setId((int)tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 0));
    
    try {
        //atualiza o banco de daods
        dao.update(funcionario);
    } catch (SQLException ex) {
        Logger.getLogger(TelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        //limpa os campos e atualiza a tabela
        limpar();
    } catch (SQLException ex) {
        Logger.getLogger(TelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
    }
    
                }                      
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void tblFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionarioMouseClicked
 selecionarItem();  

    }//GEN-LAST:event_tblFuncionarioMouseClicked

    private void tblFuncionarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblFuncionarioKeyPressed
  selecionarItem();     }//GEN-LAST:event_tblFuncionarioKeyPressed

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyPressed
      try {
            readJTableBusca(txtBusca.getText());
        } catch (SQLException ex) {
           System.out.println("Erro na Busca" + ex);
        }
    }//GEN-LAST:event_txtBuscaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaFuncionario().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jaslas;
    private javax.swing.JTable tblFuncionario;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtRg;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JFormattedTextField txtTelefone2;
    // End of variables declaration//GEN-END:variables
}
