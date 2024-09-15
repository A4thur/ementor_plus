/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ementor.plus;

/**
 *
 * @author bergamini
 */
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


public class PDFGenerator {
    private DefaultTableModel tableModel;
    public PDFGenerator(DefaultTableModel Tabela) {
        this.tableModel = Tabela;
    }
    public void exportTableModelToPDF(DefaultTableModel tableModel, String fileName) throws IOException {
        // Cria uma JTable a partir do DefaultTableModel
        JTable table = new JTable(tableModel);

        // Cria um novo documento PDF
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // Cria um stream de conteúdo para a página
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Carrega a fonte personalizada
        PDType0Font customFont = PDType0Font.load(document, new File("/home/bergamini/Downloads/Ementor-plus/lib/Roboto-Black.ttf"));

        // Define a fonte do texto (personalizada)
        contentStream.setFont(customFont, 12);

        // Obtém as dimensões da tabela
        Dimension tableSize = table.getPreferredSize();

        // Cria um BufferedImage para renderizar a tabela
        BufferedImage image = new BufferedImage(
                tableSize.width,
                tableSize.height,
                BufferedImage.TYPE_INT_RGB
        );

        // Desenha a tabela no BufferedImage
        Graphics2D g2d = image.createGraphics();
        table.paint(g2d);  // Renderiza a JTable na imagem
        g2d.dispose();

        // Cria um PDImageXObject a partir do BufferedImage
        PDImageXObject pdImage = PDImageXObject.createFromByteArray(document, ((java.awt.image.DataBufferByte) image.getRaster().getDataBuffer()).getData(), "tabela");

        // Adiciona a imagem ao PDF
        contentStream.drawImage(pdImage, 50, 700 - tableSize.height, tableSize.width, tableSize.height);

        // Fecha o stream de conteúdo
        contentStream.close();

        // Salva o documento PDF
        document.save(fileName + ".pdf");

        // Fecha o documento
        document.close();
    }
        

}





