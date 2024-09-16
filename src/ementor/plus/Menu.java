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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botaoCadastrarAluno = new javax.swing.JButton();
        botaoListarAlunos = new javax.swing.JButton();
        botaoCadastrarTurma = new javax.swing.JButton();
        botaoListarTurma = new javax.swing.JButton();
        botaoListarProfessor = new javax.swing.JButton();
        botaoCadastrarProfessor = new javax.swing.JButton();
        botaoCadastrarEgresso = new javax.swing.JButton();
        botaoListarEgresso = new javax.swing.JButton();
        PDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Menu");

        botaoCadastrarAluno.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoCadastrarAluno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCadastrarAluno.setLabel("Cadastrar Aluno");
        botaoCadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarAlunoActionPerformed(evt);
            }
        });

        botaoListarAlunos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoListarAlunos.setText("Listar Alunos");
        botaoListarAlunos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoListarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListarAlunosActionPerformed(evt);
            }
        });

        botaoCadastrarTurma.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoCadastrarTurma.setText("Cadastrar Turma");
        botaoCadastrarTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botaoListarTurma.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoListarTurma.setText("Listar Turma");
        botaoListarTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoListarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListarTurmaActionPerformed(evt);
            }
        });

        botaoListarProfessor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoListarProfessor.setText("Listar Professor");
        botaoListarProfessor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoListarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListarProfessorActionPerformed(evt);
            }
        });

        botaoCadastrarProfessor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoCadastrarProfessor.setText("Cadastrar Professor");
        botaoCadastrarProfessor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCadastrarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarProfessorActionPerformed(evt);
            }
        });

        botaoCadastrarEgresso.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoCadastrarEgresso.setText("Cadastrar Egresso");
        botaoCadastrarEgresso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCadastrarEgresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarEgressoActionPerformed(evt);
            }
        });

        botaoListarEgresso.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoListarEgresso.setText("Listar Egresso");
        botaoListarEgresso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoListarEgresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListarEgressoActionPerformed(evt);
            }
        });

        PDF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PDF.setText("PDF ALUNO");
        PDF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botaoListarAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoListarEgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botaoCadastrarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoCadastrarEgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botaoListarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botaoListarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botaoCadastrarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botaoCadastrarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(PDF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCadastrarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCadastrarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCadastrarEgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoListarAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoListarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoListarEgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoListarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(PDF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
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

    private void botaoListarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoListarTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoListarTurmaActionPerformed

    private void botaoCadastrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarAlunoActionPerformed
        CadastroAluno aluno = new CadastroAluno();
        aluno.setVisible(true);
    }//GEN-LAST:event_botaoCadastrarAlunoActionPerformed

    private void botaoCadastrarEgressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarEgressoActionPerformed
        CadastroEgresso egresso = new CadastroEgresso();
        egresso.setVisible(true);
    }//GEN-LAST:event_botaoCadastrarEgressoActionPerformed

    private void botaoCadastrarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarProfessorActionPerformed
        CadastroProfessor professor = new CadastroProfessor();
        professor.setVisible(true);
    }//GEN-LAST:event_botaoCadastrarProfessorActionPerformed

    private void botaoListarEgressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoListarEgressoActionPerformed
        TableEgresso tableEgresso = new TableEgresso();
        tableEgresso.setVisible(true);
    }//GEN-LAST:event_botaoListarEgressoActionPerformed

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
    private javax.swing.JButton botaoCadastrarAluno;
    private javax.swing.JButton botaoCadastrarEgresso;
    private javax.swing.JButton botaoCadastrarProfessor;
    private javax.swing.JButton botaoCadastrarTurma;
    private javax.swing.JButton botaoListarAlunos;
    private javax.swing.JButton botaoListarEgresso;
    private javax.swing.JButton botaoListarProfessor;
    private javax.swing.JButton botaoListarTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
