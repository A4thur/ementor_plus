/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ementor.plus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author bergamini
 */
public class Disco {
    public static  void SalvarEmDisco(ArrayList<String> lista) {
        File arquivo = new File("log.dat");
        try (FileOutputStream fout = new FileOutputStream(arquivo);
             ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(lista);
            System.out.println("Dados salvos com sucesso em log.dat.");
        } catch (Exception ex) {
            System.err.println("Erro ao salvar em log.dat: " + ex.toString());
        }
    }
    public static ArrayList<String> LerNoDisco() {
        File arquivo = new File("log.dat");
        if (arquivo.exists()) {
            try (FileInputStream fin = new FileInputStream(arquivo);
                 ObjectInputStream oin = new ObjectInputStream(fin)) {
                ArrayList<String> lista = (ArrayList<String>) oin.readObject();
                System.out.println("Dados carregados com sucesso de log.dat.");
                return lista; 
            } catch (Exception ex) {
                System.err.println("Erro ao ler de log.dat"+ ex.toString());
            }
        } else {
            System.out.println("Nenhum dado encontrado em log.dat. Um novo arquivo será criado.");
        }
        return new ArrayList<>(); 
}
}
