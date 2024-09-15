/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ementor.plus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoListarAlunos = new javax.swing.JButton();
        botaoCadastrarAluno = new javax.swing.JButton();
        botaoAlterarProfessor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botaoCadastrarProfessor = new javax.swing.JButton();
        botaoCadastrarEgresso = new javax.swing.JButton();
        botaoAlterarAluno = new javax.swing.JButton();
        botaoAlterarEgresso = new javax.swing.JButton();
        botaoListarProfessor = new javax.swing.JButton();
        botaoListarEgresso = new javax.swing.JButton();
        botaoCadastrarTurma = new javax.swing.JButton();
        botaoAlterarTurma = new javax.swing.JButton();
        botaoListarTurma = new javax.swing.JButton();
        PDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botaoListarAlunos.setText("Listar Alunos");
        botaoListarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListarAlunosActionPerformed(evt);
            }
        });

        botaoCadastrarAluno.setLabel("Cadastrar Aluno");

        botaoAlterarProfessor.setText("Alterar Professor");

        jLabel1.setText("Menu");

        botaoCadastrarProfessor.setText("Cadastrar Professor");

        botaoCadastrarEgresso.setText("Cadastrar Egresso");

        botaoAlterarAluno.setText("Alterar Aluno");

        botaoAlterarEgresso.setText("Alterar Egresso");

        botaoListarProfessor.setText("Listar Professor");
        botaoListarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListarProfessorActionPerformed(evt);
            }
        });

        botaoListarEgresso.setText("Listar Egresso");

        botaoCadastrarTurma.setText("Cadastrar Turma");

        botaoAlterarTurma.setText("Alterar Turma");

        botaoListarTurma.setText("Listar Turma");

        PDF.setText("PDF ALUNO");
        PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoListarProfessor)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 228, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap(302, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoListarTurma)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoListarAlunos)
                            .addComponent(botaoListarEgresso)
                            .addComponent(botaoAlterarTurma))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoCadastrarProfessor)
                            .addComponent(botaoCadastrarAluno)
                            .addComponent(botaoCadastrarEgresso)
                            .addComponent(botaoCadastrarTurma)
                            .addComponent(PDF))
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botaoAlterarAluno)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoAlterarProfessor)
                            .addComponent(botaoAlterarEgresso))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(botaoListarTurma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoListarProfessor)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoListarEgresso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoListarAlunos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(botaoCadastrarAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoCadastrarProfessor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoCadastrarEgresso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoCadastrarTurma)
                        .addGap(2, 2, 2)))
                .addComponent(botaoAlterarAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoAlterarProfessor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoAlterarEgresso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAlterarTurma)
                    .addComponent(PDF))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoListarAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoListarAlunosActionPerformed
        TabelaAlunos alunos  = new TabelaAlunos();
        alunos.setVisible(true);
    }//GEN-LAST:event_botaoListarAlunosActionPerformed

    private void botaoListarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoListarProfessorActionPerformed
        TableProfessor professores = new TableProfessor();
        professores.setVisible(true);
    }//GEN-LAST:event_botaoListarProfessorActionPerformed
                               
    
    private void PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PDFActionPerformed
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


    

    
        PDFGenerator pdf = new PDFGenerator(Tabela); // Passa o DefaultTableModel para o construtor
        try {
pdf.exportTableModelToPDF(Tabela, "relatorio.pdf");
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!");
        JOptionPane.showMessageDialog(null, "Tabela ou modelo não inicializados.");


    }//GEN-LAST:event_PDFActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PDF;
    private javax.swing.JButton botaoAlterarAluno;
    private javax.swing.JButton botaoAlterarEgresso;
    private javax.swing.JButton botaoAlterarProfessor;
    private javax.swing.JButton botaoAlterarTurma;
    private javax.swing.JButton botaoCadastrarAluno;
    private javax.swing.JButton botaoCadastrarEgresso;
    private javax.swing.JButton botaoCadastrarProfessor;
    private javax.swing.JButton botaoCadastrarTurma;
    private javax.swing.JButton botaoListarAlunos;
    private javax.swing.JButton botaoListarEgresso;
    private javax.swing.JButton botaoListarProfessor;
    private javax.swing.JButton botaoListarTurma;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
