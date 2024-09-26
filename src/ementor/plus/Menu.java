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
import javax.swing.JTable;
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
        pdfTurma = new javax.swing.JButton();
        pdfProfessor = new javax.swing.JButton();
        pdfEgresso = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menu");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        botaoCadastrarAluno.setBackground(new java.awt.Color(102, 102, 102));
        botaoCadastrarAluno.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botaoCadastrarAluno.setForeground(new java.awt.Color(255, 255, 255));
        botaoCadastrarAluno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoCadastrarAluno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoCadastrarAluno.setLabel("Cadastrar Aluno");
        botaoCadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarAlunoActionPerformed(evt);
            }
        });

        botaoListarAlunos.setBackground(new java.awt.Color(102, 102, 102));
        botaoListarAlunos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botaoListarAlunos.setForeground(new java.awt.Color(255, 255, 255));
        botaoListarAlunos.setText("Listar Alunos");
        botaoListarAlunos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoListarAlunos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoListarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListarAlunosActionPerformed(evt);
            }
        });

        botaoCadastrarTurma.setBackground(new java.awt.Color(102, 102, 102));
        botaoCadastrarTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botaoCadastrarTurma.setForeground(new java.awt.Color(255, 255, 255));
        botaoCadastrarTurma.setText("Cadastrar Turma");
        botaoCadastrarTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoCadastrarTurma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoCadastrarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarTurmaActionPerformed(evt);
            }
        });

        botaoListarTurma.setBackground(new java.awt.Color(102, 102, 102));
        botaoListarTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botaoListarTurma.setForeground(new java.awt.Color(255, 255, 255));
        botaoListarTurma.setText("Listar Turma");
        botaoListarTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoListarTurma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoListarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListarTurmaActionPerformed(evt);
            }
        });

        botaoListarProfessor.setBackground(new java.awt.Color(102, 102, 102));
        botaoListarProfessor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botaoListarProfessor.setForeground(new java.awt.Color(255, 255, 255));
        botaoListarProfessor.setText("Listar Professor");
        botaoListarProfessor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoListarProfessor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoListarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListarProfessorActionPerformed(evt);
            }
        });

        botaoCadastrarProfessor.setBackground(new java.awt.Color(102, 102, 102));
        botaoCadastrarProfessor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botaoCadastrarProfessor.setForeground(new java.awt.Color(255, 255, 255));
        botaoCadastrarProfessor.setText("Cadastrar Professor");
        botaoCadastrarProfessor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoCadastrarProfessor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoCadastrarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarProfessorActionPerformed(evt);
            }
        });

        botaoCadastrarEgresso.setBackground(new java.awt.Color(102, 102, 102));
        botaoCadastrarEgresso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botaoCadastrarEgresso.setForeground(new java.awt.Color(255, 255, 255));
        botaoCadastrarEgresso.setText("Cadastrar Egresso");
        botaoCadastrarEgresso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoCadastrarEgresso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoCadastrarEgresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarEgressoActionPerformed(evt);
            }
        });

        botaoListarEgresso.setBackground(new java.awt.Color(102, 102, 102));
        botaoListarEgresso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botaoListarEgresso.setForeground(new java.awt.Color(255, 255, 255));
        botaoListarEgresso.setText("Listar Egresso");
        botaoListarEgresso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoListarEgresso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoListarEgresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListarEgressoActionPerformed(evt);
            }
        });

        PDF.setBackground(new java.awt.Color(102, 102, 102));
        PDF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PDF.setForeground(new java.awt.Color(255, 255, 255));
        PDF.setText("PDF ALUNO");
        PDF.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PDF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PDFActionPerformed(evt);
            }
        });

        pdfTurma.setBackground(new java.awt.Color(102, 102, 102));
        pdfTurma.setFont(new java.awt.Font("Noto Sans Nerd Font", 1, 14)); // NOI18N
        pdfTurma.setForeground(new java.awt.Color(255, 255, 255));
        pdfTurma.setText("PDF TURMA");
        pdfTurma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pdfTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfTurmaActionPerformed(evt);
            }
        });

        pdfProfessor.setBackground(new java.awt.Color(102, 102, 102));
        pdfProfessor.setFont(new java.awt.Font("Noto Sans Nerd Font", 1, 14)); // NOI18N
        pdfProfessor.setForeground(new java.awt.Color(255, 255, 255));
        pdfProfessor.setText("PDF PROFESSOR");
        pdfProfessor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pdfProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfProfessorActionPerformed(evt);
            }
        });

        pdfEgresso.setBackground(new java.awt.Color(102, 102, 102));
        pdfEgresso.setFont(new java.awt.Font("Noto Sans Nerd Font", 1, 14)); // NOI18N
        pdfEgresso.setForeground(new java.awt.Color(255, 255, 255));
        pdfEgresso.setText("PDF EGRESSO");
        pdfEgresso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pdfEgresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfEgressoActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 204, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/picture_as_pdf_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jButton2.setBackground(new java.awt.Color(102, 204, 255));
        jButton2.setBorderPainted(false);

        jButton3.setBackground(new java.awt.Color(102, 204, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/list_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        jButton3.setBorderPainted(false);

        jButton4.setBackground(new java.awt.Color(102, 204, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        jButton4.setBorderPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(661, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(649, 649, 649))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoListarAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCadastrarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PDF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoCadastrarEgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pdfProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoListarEgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoCadastrarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pdfTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoListarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pdfEgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoListarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCadastrarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoCadastrarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botaoListarAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PDF, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoCadastrarEgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoListarEgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(pdfProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoCadastrarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoCadastrarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoListarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoListarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pdfTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pdfEgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(193, 193, 193))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        ArrayList <Object> ListaAlunos = new ArrayList(); 
        
        Aluno busca = new Aluno();
        ListaAlunos = (ArrayList<Object>) (Object) busca.mostrarAlunos();
        String[] colunas = {
            // Pessoa
            "Nome",
            "Data Nascimento",
            "CPF",
            "Telefone",
            "Rua",
            "Bairro",
            "Cidade",
            "Estado",

            // Aluno
            "Matricula",
            "Periodo",
            "Finalizado"
        };

        String filePath = "/home/bergamini/Downloads/ementorp/ementor_plus/relatorioaluno.pdf";
        String subtitulo = "Alunos";
        PDFGenerator pdf = new PDFGenerator();
        pdf.gerarPDF(colunas,ListaAlunos, filePath, subtitulo);
        JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!");


    }//GEN-LAST:event_PDFActionPerformed

    private void botaoListarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoListarTurmaActionPerformed
        TableTurmas turmas = new TableTurmas();
        turmas.setVisible(true);
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

    private void botaoCadastrarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarTurmaActionPerformed
        CadastroTurma turma = new CadastroTurma();
        turma.setVisible(true);
    }//GEN-LAST:event_botaoCadastrarTurmaActionPerformed

    private void pdfProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfProfessorActionPerformed
        ArrayList<Object> ListaProfessores = new ArrayList<>();

        Professor buscaProfessor = new Professor();
        ListaProfessores = (ArrayList<Object>) (Object) buscaProfessor.mostrarProfessor();

        String[] colunasProfessores = {
            // Pessoa
            "Nome",
            "Data Nascimento",
            "CPF",
            "Telefone",
            "Rua",
            "Bairro",
            "Cidade",
            "Estado",

            // Professor
            "Data Admissao",
            "Chefia",
            "Coordenacao",
            "Salario"
        };

        String filePathProfessores = "/home/bergamini/Downloads/ementorp/ementor_plus/relatorioprofessor.pdf";
        String subtituloProfessores = "Professores";
        PDFGenerator pdf = new PDFGenerator();
        pdf.gerarPDF(colunasProfessores, ListaProfessores, filePathProfessores, subtituloProfessores);
        JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!");

    }//GEN-LAST:event_pdfProfessorActionPerformed

    private void pdfEgressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfEgressoActionPerformed
        ArrayList<Object> ListaEgressos = new ArrayList<>();
        Egresso buscaEgresso = new Egresso();
        ListaEgressos = (ArrayList<Object>) (Object) buscaEgresso.mostrarEgressos();

        String[] colunasEgressos = {
            // Pessoa
            "Nome",
            "Data Nascimento",
            "CPF",
            "Telefone",
            "Rua",
            "Bairro",
            "Cidade",
            "Estado",

            // Egresso
            "Profissao",
            "Faixa Salarial",
            "Curso Anterior",
            "Curso Atual"
        };

        String filePathEgressos = "/home/bergamini/Downloads/ementorp/ementor_plus/relatorioegresso.pdf";
        String subtituloEgressos = "Egressos";
        PDFGenerator pdf = new PDFGenerator();
        pdf.gerarPDF(colunasEgressos, ListaEgressos, filePathEgressos, subtituloEgressos);
        JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!");
    }//GEN-LAST:event_pdfEgressoActionPerformed

    private void pdfTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfTurmaActionPerformed
        ArrayList<Object> ListaTurmas = new ArrayList<>();
        Turma buscaTurma = new Turma();
        ListaTurmas = (ArrayList<Object>) (Object) buscaTurma.mostrarTurmas();

        String[] colunasTurmas = {
            // Turma
            "Professor Responsável",
            "Nome da Turma",
            "Código",
            "Número de Avaliações"
        };

        String filePathTurmas = "/home/bergamini/Downloads/ementorp/ementor_plus/relatorioturma.pdf";
        String subtituloTurmas = "Turmas";
        PDFGenerator pdf = new PDFGenerator();
        pdf.gerarPDF(colunasTurmas, ListaTurmas, filePathTurmas, subtituloTurmas);
        JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!");
    }//GEN-LAST:event_pdfTurmaActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton pdfEgresso;
    private javax.swing.JButton pdfProfessor;
    private javax.swing.JButton pdfTurma;
    // End of variables declaration//GEN-END:variables
}
