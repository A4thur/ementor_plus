/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ementor.plus;

import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class TabelaAlunos extends javax.swing.JFrame {

    /**
     * Creates new form TableAluno
     */
    public TabelaAlunos() {
        initComponents();
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        
    }
    
    
    
    public void TelaCheia(){
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableAluno = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        CCpf = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TableAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Data de Nascimento", "CPF", "Telefone", "Rua", "Bairro", "Cidade", "Estado", "Matrícula", "Período", "Turma", "Notas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableAluno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TableAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAlunoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableAluno);

        jRadioButton1.setText("Editar/Deletar");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Ver Turmas");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("CPF");

        CCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCpfActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1489, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(127, 127, 127)
                .addComponent(jRadioButton1)
                .addGap(50, 50, 50)
                .addComponent(jRadioButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jLabel1)
                    .addComponent(CCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAlunoMouseClicked
        int selectedRow = TableAluno.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) TableAluno.getModel();
        String cpf = model.getValueAt(selectedRow, 2).toString();
        if(jRadioButton1.isSelected()){
            editOrDeleteAluno p = new editOrDeleteAluno(cpf);
            p.setVisible(true);
        }else if(jRadioButton2.isSelected()){
            TableTurma t = new TableTurma(cpf);
            t.setVisible(true);
        }
    }//GEN-LAST:event_TableAlunoMouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jRadioButton1.setSelected(true);
        jRadioButton2.setSelected(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void CCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CCpfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel Tabela = (DefaultTableModel) TableAluno.getModel();
        ArrayList <Aluno> ListaAlunos;
        
        Aluno busca = new Aluno();
        Tabela.setRowCount(0);
        if(CCpf.getText().isEmpty()){
            ListaAlunos = busca.mostrarAlunos();
        }else{
            ListaAlunos = busca.mostrarAlunos(CCpf.getText());
        }
        for(Aluno obj: ListaAlunos) {
            Tabela.addRow(new Object[] {obj.nome, 
                                        obj.dataNascimento,
                                        obj.cpf,
                                        obj.telefone,
                                        obj.rua,
                                        obj.bairro,
                                        obj.cidade,
                                        obj.estado, 
                                        obj.getMatricula(),
                                        obj.getPeriodo()});
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        ArrayList <Aluno> ListaAlunos; 
        
        
        Aluno busca = new Aluno();
        ListaAlunos = busca.mostrarAlunos();
        
        DefaultTableModel Tabela = (DefaultTableModel) TabelaAlunos.TableAluno.getModel();
        for(Aluno obj: ListaAlunos) {
            Tabela.addRow(new Object[] {obj.nome, 
                                        obj.dataNascimento,
                                        obj.cpf,
                                        obj.telefone,
                                        obj.rua,
                                        obj.bairro,
                                        obj.cidade,
                                        obj.estado, 
                                        obj.getMatricula(),
                                        obj.getPeriodo()});
        }
        TelaCheia();
        
    }   
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
            java.util.logging.Logger.getLogger(TabelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabelaAlunos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CCpf;
    public static javax.swing.JTable TableAluno;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
