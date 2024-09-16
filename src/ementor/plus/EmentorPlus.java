/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ementor.plus;

/**
 *
 * @author aluno
 */
public class EmentorPlus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Professor professor = new Professor("30092002", true, true, 20000f, "sim2", "sim3", "sim4", "sim5", "sim6", "sim7", "sim8", "sim9");
        professor.atualiza("149.639.807-63");
        
        Login login = new Login();
        login.setVisible(true);
        
       
    }
    
}
