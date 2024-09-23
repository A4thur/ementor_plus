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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class PDFGenerator {

    public void gerarPDF(String[] colunas, ArrayList<Object> lista, String filePath, String subtitulo) {
    try (PDDocument document = new PDDocument()) {
        // Gerar nome de arquivo único se o original já existir
        filePath = gerarNomeUnico(filePath);

        // Define a página em paisagem
        PDRectangle landscape = new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth());
        PDPage page = new PDPage(landscape);
        document.addPage(page);

        // Carregar fonte personalizada
        PDType0Font customFont = PDType0Font.load(document, new File("/home/bergamini/Downloads/ementorp/ementor_plus/lib/Roboto-Black.ttf"));

        // Definindo as fontes customizadas
        PDFont font = customFont;
        PDFont fontNormal = customFont;

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Definir margem e posição inicial
        float margin = 50;
        float pageWidth = page.getMediaBox().getWidth() - (2 * margin); // Largura da página sem margem
        float yStart = page.getMediaBox().getHeight() - margin;
        float cellHeight = 20; // Altura de cada célula
        float cellMargin = 5; // Margem interna da célula

        // Definir largura das colunas proporcionalmente à largura da página
        float[] colWidths = new float[colunas.length];
        for (int i = 0; i < colunas.length; i++) {
            colWidths[i] = pageWidth / colunas.length; // Dividindo igualmente a largura
        }

        // Centralizar o título
        String titulo = "Relatório de Migração de Dados";
        contentStream.beginText();
        contentStream.setFont(font, 16);
        float titleWidth = (font.getStringWidth(titulo) / 1000) * 16;
        contentStream.newLineAtOffset((page.getMediaBox().getWidth() - titleWidth) / 2, yStart);
        contentStream.showText(titulo);
        contentStream.endText();

        // Espaçamento após título
        yStart -= 25;

        // Subtítulo com nome e data
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String subTituloTexto = subtitulo + " - " + formatter.format(date);

        contentStream.beginText();
        contentStream.setFont(font, 12);
        float subtitleWidth = (font.getStringWidth(subTituloTexto) / 1000) * 12;
        contentStream.newLineAtOffset((page.getMediaBox().getWidth() - subtitleWidth) / 2, yStart);
        contentStream.showText(subTituloTexto);
        contentStream.endText();

        // Espaçamento após subtítulo
        yStart -= 20;

        // Desenhar a tabela - Cabeçalhos
        float xPos = margin;
        for (int i = 0; i < colunas.length; i++) {
            contentStream.addRect(xPos, yStart - cellHeight, colWidths[i], cellHeight);
            contentStream.setNonStrokingColor(220 / 255f, 220 / 255f, 220 / 255f); // Cor de fundo do cabeçalho
            contentStream.fill(); // Preenche a célula
            contentStream.setNonStrokingColor(0, 0, 0); // Cor da borda
            contentStream.addRect(xPos, yStart - cellHeight, colWidths[i], cellHeight);
            contentStream.stroke();

            contentStream.beginText();
            contentStream.setFont(font, 8); // Fonte maior para cabeçalhos
            float textWidth = (font.getStringWidth(colunas[i]) / 1000) * 8;
            contentStream.newLineAtOffset(xPos + (colWidths[i] - textWidth) / 2, yStart - cellHeight + cellMargin);
            contentStream.showText(colunas[i]);
            contentStream.endText();
            xPos += colWidths[i];
        }
        yStart -= cellHeight;

        // Preencher os dados da lista (genérico)
        for (Object obj : lista) {
            if (yStart < margin + cellHeight) {
                // Nova página se atingir o limite
                contentStream.close();
                page = new PDPage(landscape);
                document.addPage(page);
                contentStream = new PDPageContentStream(document, page);
                yStart = page.getMediaBox().getHeight() - margin;

                // Recria cabeçalhos na nova página
                xPos = margin;
                for (int i = 0; i < colunas.length; i++) {
                    contentStream.addRect(xPos, yStart - cellHeight, colWidths[i], cellHeight);
                    contentStream.setNonStrokingColor(220 / 255f, 220 / 255f, 220 / 255f); // Cor de fundo do cabeçalho
                    contentStream.fill(); // Preenche a célula
                    contentStream.setNonStrokingColor(0, 0, 0); // Cor da borda
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

            // Desenhar os dados do objeto em cada célula
            xPos = margin;
            for (int i = 0; i < colunas.length; i++) {
                String valor = "N/A"; // Valor padrão para coluna não encontrada

                // Verificar a instância e usar métodos específicos de cada classe
                switch (colunas[i]) {
                    // Pessoa
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

                    // Aluno
                    case "Matricula":
                        if (obj instanceof Aluno) valor = ((Aluno) obj).getMatricula();
                        break;
                    case "Periodo":
                        if (obj instanceof Aluno) valor = String.valueOf(((Aluno) obj).getPeriodo());
                        break;
                    case "Finalizado":
                        if (obj instanceof Aluno) valor = String.valueOf(((Aluno) obj).isFinalizado());
                        break;

                    // Professor
                    case "Data Admissao":
                        if (obj instanceof Professor) valor = ((Professor) obj).getDataAdmissao();
                        break;
                    case "Chefia":
                        if (obj instanceof Professor) valor = String.valueOf(((Professor) obj).getChefia());
                        break;
                    case "Coordenacao":
                        if (obj instanceof Professor) valor = String.valueOf(((Professor) obj).getCoordenacao());
                        break;
                    case "Salario":
                        if (obj instanceof Professor) valor = String.valueOf(((Professor) obj).getSalario());
                        break;

                    // Egresso
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

                    // Turma
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
                }

                contentStream.addRect(xPos, yStart - cellHeight, colWidths[i], cellHeight);
                contentStream.setNonStrokingColor(255 / 255f, 255 / 255f, 255 / 255f); // Cor de fundo dos dados
                contentStream.fill(); // Preenche a célula
                contentStream.setNonStrokingColor(0, 0, 0); // Cor da borda
                contentStream.addRect(xPos, yStart - cellHeight, colWidths[i], cellHeight);
                contentStream.stroke();

                contentStream.beginText();
                contentStream.setFont(fontNormal, 7);
                float textWidth = (fontNormal.getStringWidth(valor) / 1000) * 7;
                contentStream.newLineAtOffset(xPos + (colWidths[i] - textWidth) / 2, yStart - cellHeight + cellMargin);
                contentStream.showText(valor);
                contentStream.endText();
                xPos += colWidths[i];
            }
            contentStream.stroke();
            yStart -= cellHeight;
        }

        // Fecha o fluxo de conteúdo
        contentStream.close();

        // Salvar o documento PDF
        document.save(filePath);
        System.out.println("PDF gerado com sucesso: " + filePath);
    } catch (IOException e) {
        e.printStackTrace();
    }
}


// Função para gerar nome de arquivo único
    public String gerarNomeUnico(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return filePath; // Se o arquivo não existe, retorna o caminho original
        }

        String baseName = filePath.substring(0, filePath.lastIndexOf('.'));
        String extension = filePath.substring(filePath.lastIndexOf('.'));

        int counter = 1;
        while (file.exists()) {
            filePath = baseName + " (" + counter + ")" + extension;
            file = new File(filePath);
            counter++;
        }
        return filePath;
    }

}









