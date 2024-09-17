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
import java.util.ArrayList;

public class PDFGenerator {

    public void gerarPDF(String[] colunas, ArrayList<Aluno> alunos, String filePath) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            // Carregar fonte personalizada
            PDType0Font customFont = PDType0Font.load(document, new File("/home/bergamini/Downloads/ementorp/ementor_plus/lib/Roboto-Black.ttf"));

            // Definindo as fontes customizadas
            PDFont font = customFont;
            PDFont fontNormal = customFont;

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Definir margem e posição inicial
            float margin = 50;
            float yStart = page.getMediaBox().getHeight() - margin;

            // Título
            contentStream.beginText();
            contentStream.setFont(font, 18);
            contentStream.newLineAtOffset(margin, yStart);
            contentStream.showText("Relatório de Migração de Dados");
            contentStream.endText();

            // Espaçamento após título
            yStart -= 25;

            // Desenhar cabeçalhos das colunas
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(margin, yStart);
            for (String coluna : colunas) {
                contentStream.showText(coluna + "    "); // Espaçamento entre colunas
            }
            contentStream.endText();

            // Espaçamento após cabeçalhos
            yStart -= 20;

            // Preencher os dados dos alunos
            for (Aluno aluno : alunos) {
                if (yStart < margin) {
                    // Nova página se atingir o limite
                    contentStream.close();
                    page = new PDPage();
                    document.addPage(page);
                    contentStream = new PDPageContentStream(document, page);
                    yStart = page.getMediaBox().getHeight() - margin;
                    
                    // Recria cabeçalhos na nova página
                    contentStream.beginText();
                    contentStream.setFont(font, 12);
                    contentStream.newLineAtOffset(margin, yStart);
                    for (String coluna : colunas) {
                        contentStream.showText(coluna + "    ");
                    }
                    contentStream.endText();
                    
                    // Espaçamento após cabeçalhos
                    yStart -= 20;
                }

                contentStream.beginText();
                contentStream.setFont(fontNormal, 12);
                contentStream.newLineAtOffset(margin, yStart);

                // Preencher os dados dos alunos com base na ordem das colunas
                for (String coluna : colunas) {
                    String valor = "N/A"; // Valor padrão para coluna não encontrada
                    switch (coluna) {
                        case "Nome":
                            valor = aluno.getNome();
                            break;
                        case "Data Nascimento":
                            valor = aluno.getDataNascimento();
                            break;
                        case "CPF":
                            valor = aluno.getCpf();
                            break;
                        case "Telefone":
                            valor = aluno.getTelefone();
                            break;
                        case "Rua":
                            valor = aluno.getRua();
                            break;
                        case "Bairro":
                            valor = aluno.getBairro();
                            break;
                        case "Cidade":
                            valor = aluno.getCidade();
                            break;
                        case "Estado":
                            valor = aluno.getEstado();
                            break;
                        case "Matricula":
                            valor = aluno.getMatricula();
                            break;
                        case "Periodo":
                            valor = String.valueOf(aluno.getPeriodo());
                            break;
                        case "Finalizado":
                            valor = String.valueOf(aluno.isFinalizado());
                            break;
                        // Adicione mais casos se necessário
                    }
                    contentStream.showText(valor + "    ");
                }

                contentStream.endText();
                yStart -= 15;
            }

            contentStream.close();
            document.save(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}








