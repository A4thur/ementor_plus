/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ementor.plus.LogErros;

/**
 *
 * @author carlo
 */
public class SQLPresencaException extends RuntimeException{

    public SQLPresencaException() {
        super("erro 102: tentativa de acessar item inexistente no banco de dados.");
    }
    
}
