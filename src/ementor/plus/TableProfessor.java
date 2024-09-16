/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ementor.plus;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class TableProfessor extends javax.swing.JFrame {

    /**
     * Creates new form TableProfessor
     */
    public TableProfessor() {
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
    public static void initializeTable() {
        // Definindo as colunas e os dados iniciais da tabela
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Nome", "CPF", "Data Nascimento", "Telefone", "Rua", "Bairro", "Cidade", "Estado", "Data Admissao", "Chefia", "Coordenacao"},
            0
        );
        TabelaProfessor.setModel(model);
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
        TabelaProfessor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TabelaProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome ", "Data de Nascimento", "CPF", "Telefone", "Rua", "Rua", "Bairro", "Cidade", "Estado", "Data de Admissão", "Chefia", "Coordenação", "Salário Bruto"
            }
        ));
        TabelaProfessor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TabelaProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaProfessorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaProfessor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1227, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelaProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaProfessorMouseClicked
        editOrDeleteProfessor p = new editOrDeleteProfessor();
        p.setVisible(true);
    }//GEN-LAST:event_TabelaProfessorMouseClicked
    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        ArrayList <Professor> ListaProfessores = new ArrayList(); 
        
        Professor busca = new Professor();
        ListaProfessores = busca.mostrarProfessor();
        
        DefaultTableModel Tabela = (DefaultTableModel) TableProfessor.TabelaProfessor.getModel();
        for(Professor obj: ListaProfessores) {
            Tabela.addRow(new Object[] {obj.nome, 
                                        obj.cpf, 
                                        obj.dataNascimento,
                                        obj.telefone,
                                        obj.rua,
                                        obj.bairro,
                                        obj.cidade,
                                        obj.estado, 
                                        obj.getDataAdmissao(),
                                        obj.getChefia(),
                                        obj.getCoordenacao(),
                                        obj.getChefia()});
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
            java.util.logging.Logger.getLogger(TableProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableProfessor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TabelaProfessor;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
