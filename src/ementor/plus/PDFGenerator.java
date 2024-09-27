/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ementor.plus;

/**
 *
 * @author bergamini
 */
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.*;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.pdfbox.pdmodel.common.PDRectangle;


import java.nio.file.Paths;
import java.nio.file.Path;

public class PDFGenerator {

    public void gerarPDF(String[] colunas, ArrayList<Object> lista, String nomeArquivo, String subtitulo) {
        try (PDDocument document = new PDDocument()) {
            
            String userHome = System.getProperty("user.home");
            Path downloadsPath = Paths.get(userHome, "Downloads", nomeArquivo + ".pdf");

            
            String filePath = gerarNomeUnico(downloadsPath.toString());

            
            PDRectangle landscape = new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth());
            PDPage page = new PDPage(landscape);
            document.addPage(page);

            
            InputStream fontStream = getClass().getResourceAsStream("/Roboto-Black.ttf");
            PDType0Font customFont = PDType0Font.load(document, fontStream);


           
            PDFont font = customFont;
            PDFont fontNormal = customFont;

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            
            float margin = 50;
            float pageWidth = page.getMediaBox().getWidth() - (2 * margin); 
            float yStart = page.getMediaBox().getHeight() - margin;
            float cellHeight = 20; 
            float cellMargin = 5; 

            
            float[] colWidths = new float[colunas.length];
            for (int i = 0; i < colunas.length; i++) {
                colWidths[i] = pageWidth / colunas.length; 
            }

            
            String titulo = "Relatório de Migração de Dados";
            contentStream.beginText();
            contentStream.setFont(font, 16);
            float titleWidth = (font.getStringWidth(titulo) / 1000) * 16;
            contentStream.newLineAtOffset((page.getMediaBox().getWidth() - titleWidth) / 2, yStart);
            contentStream.showText(titulo);
            contentStream.endText();

            
            yStart -= 25;

            
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String subTituloTexto = subtitulo + " - " + formatter.format(date);

            contentStream.beginText();
            contentStream.setFont(font, 12);
            float subtitleWidth = (font.getStringWidth(subTituloTexto) / 1000) * 12;
            contentStream.newLineAtOffset((page.getMediaBox().getWidth() - subtitleWidth) / 2, yStart);
            contentStream.showText(subTituloTexto);
            contentStream.endText();

           
            yStart -= 20;

            
            float xPos = margin;
            for (int i = 0; i < colunas.length; i++) {
                contentStream.addRect(xPos, yStart - cellHeight, colWidths[i], cellHeight);
                contentStream.setNonStrokingColor(220 / 255f, 220 / 255f, 220 / 255f);
                contentStream.fill();
                contentStream.setNonStrokingColor(0, 0, 0);
                contentStream.addRect(xPos, yStart - cellHeight, colWidths[i], cellHeight);
                contentStream.stroke();

                contentStream.beginText();
                contentStream.setFont(font, 8);
                float textWidth = (font.getStringWidth(colunas[i]) / 1000) * 8;
                contentStream.newLineAtOffset(xPos + (colWidths[i] - textWidth) / 2, yStart - cellHeight + cellMargin);
                contentStream.showText(colunas[i]);
                contentStream.endText();
                xPos += colWidths[i];
            }
            yStart -= cellHeight;

            
            for (Object obj : lista) {
                if (yStart < margin + cellHeight) {
                    
                    contentStream.close();
                    page = new PDPage(landscape);
                    document.addPage(page);
                    contentStream = new PDPageContentStream(document, page);
                    yStart = page.getMediaBox().getHeight() - margin;

                   
                    xPos = margin;
                    for (int i = 0; i < colunas.length; i++) {
                        contentStream.addRect(xPos, yStart - cellHeight, colWidths[i], cellHeight);
                        contentStream.setNonStrokingColor(220 / 255f, 220 / 255f, 220 / 255f); 
                        contentStream.fill(); 
                        contentStream.setNonStrokingColor(0, 0, 0); 
                        contentStream.addRect(xPos, yStart - cellHeight, colWidths[i], cellHeight);
                        contentStream.stroke();

                        contentStream.beginText();
                        contentStream.setFont(font, 8);
                        float textWidth = (font.getStringWidth(colunas[i]) / 1000) * 8;
                        contentStream.newLineAtOffset(xPos + (colWidths[i] - textWidth) / 2, yStart - cellHeight + cellMargin);
                        contentStream.showText(colunas[i]);
                        contentStream.endText();
                        xPos += colWidths[i];
                    }
                    yStart -= cellHeight;
                }

                
                xPos = margin;
                for (int i = 0; i < colunas.length; i++) {
                    String valor = "N/A"; 
                    float textWidth = 0; 

                    
                    switch (colunas[i]) {
                        
                        case "Nome":
                            if (obj instanceof Pessoa) valor = ((Pessoa) obj).getNome();
                            break;
                        case "Data Nascimento":
                            if (obj instanceof Pessoa) valor = ((Pessoa) obj).getDataNascimento();
                            break;
                        case "CPF":
                            if (obj instanceof Pessoa) valor = ((Pessoa) obj).getCpf();
                            break;
                        case "Telefone":
                            if (obj instanceof Pessoa) valor = ((Pessoa) obj).getTelefone();
                            break;
                        case "Rua":
                            if (obj instanceof Pessoa) valor = ((Pessoa) obj).getRua();
                            break;
                        case "Bairro":
                            if (obj instanceof Pessoa) valor = ((Pessoa) obj).getBairro();
                            break;
                        case "Cidade":
                            if (obj instanceof Pessoa) valor = ((Pessoa) obj).getCidade();
                            break;
                        case "Estado":
                            if (obj instanceof Pessoa) valor = ((Pessoa) obj).getEstado();
                            break;

                       
                        case "Matricula":
                            if (obj instanceof Aluno) valor = ((Aluno) obj).getMatricula();
                            break;
                        case "Periodo":
                            if (obj instanceof Aluno) valor = String.valueOf(((Aluno) obj).getPeriodo());
                            break;
                        case "Finalizado":
                            if (obj instanceof Aluno) valor = String.valueOf(((Aluno) obj).Finalizado());
                            break;

                        
                        case "Data Admissao":
                            if (obj instanceof Professor) valor = ((Professor) obj).getDataAdmissao();
                            break;
                        case "Chefia":
                            if (obj instanceof Professor) valor = String.valueOf(((Professor) obj).Chefia());
                            break;
                        case "Coordenacao":
                            if (obj instanceof Professor) valor = String.valueOf(((Professor) obj).Coordenacao());
                            break;
                        case "Salario":
                            if (obj instanceof Professor) valor = String.valueOf(((Professor) obj).getSalario());
                            break;

                        
                        case "Profissao":
                            if (obj instanceof Egresso) valor = ((Egresso) obj).getProfissao();
                            break;
                        case "Faixa Salarial":
                            if (obj instanceof Egresso) valor = ((Egresso) obj).getFaixaSalarial();
                            break;
                        case "Curso Anterior":
                            if (obj instanceof Egresso) valor = ((Egresso) obj).getCursoAnterior();
                            break;
                        case "Curso Atual":
                            if (obj instanceof Egresso) valor = ((Egresso) obj).getCursoAtual();
                            break;

                       
                        case "Professor Responsável":
                            if (obj instanceof Turma) valor = ((Turma) obj).getProfessorResponsvel();
                            break;
                        case "Nome da Turma":
                            if (obj instanceof Turma) valor = ((Turma) obj).getNome();
                            break;
                        case "Código":
                            if (obj instanceof Turma) valor = ((Turma) obj).getCodigo();
                            break;
                        case "Número de Avaliações":
                            if (obj instanceof Turma) valor = String.valueOf(((Turma) obj).getnAvaliacoes());
                            break;

                        default:
                            break;
                    }

                    
                    contentStream.addRect(xPos, yStart - cellHeight, colWidths[i], cellHeight);
                    contentStream.stroke();

                    contentStream.beginText();
                    contentStream.setFont(fontNormal, 8);
                    textWidth = (fontNormal.getStringWidth(valor) / 1000) * 8;
                    contentStream.newLineAtOffset(xPos + (colWidths[i] - textWidth) / 2, yStart - cellHeight + cellMargin);
                    contentStream.showText(valor);
                    contentStream.endText();

                    xPos += colWidths[i];
                }

                yStart -= cellHeight;
            }

            contentStream.close();

           
            document.save(filePath);

        } catch (IOException e) {
            e.printStackTrace();
             try {
                Disco disco = new Disco();
                ArrayList<String> logErros = disco.LerNoDisco();
                logErros.add(e.toString()); // Adiciona o erro capturado ao log
                disco.SalvarEmDisco(logErros);
                System.err.println("Erro capturado e salvo: " + e.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    
    private String gerarNomeUnico(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return filePath;
        }

        String baseName = filePath.substring(0, filePath.lastIndexOf('.'));
        String extension = filePath.substring(filePath.lastIndexOf('.'));
        int counter = 1;

        while (file.exists()) {
            file = new File(baseName + "_" + counter + extension);
            counter++;
        }

        return file.getPath();
    }
}










