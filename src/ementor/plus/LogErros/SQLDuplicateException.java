/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ementor.plus.LogErros;

/**
 *
 * @author carlo
 */
public class SQLDuplicateException extends RuntimeException{
    public SQLDuplicateException() {
        super("erro 101: tentativa duplicação de item unico no banco de dados.");
    }
}
