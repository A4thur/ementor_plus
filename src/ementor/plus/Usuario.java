/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ementor.plus;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Usuario extends Pessoa {
    private String nomeUsuario, senha;
    private int nivelAcesso;

    public Usuario(String nomeUsuario, String senha, int nivelAcesso, String nome, String dataNascimento, String cpf, String telefone, String rua, String bairro, String cidade, String estado) {
        super(nome, dataNascimento, cpf, telefone, rua, bairro, cidade, estado);
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }
    public Usuario(){
        super();
        this.nomeUsuario = "";
        this.senha = "";
        this.nivelAcesso = 1;
    }

    

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    public void imprimir(){
        super.imprimir();
        System.out.println("Usuario:" + this.nomeUsuario);
        System.out.println("Senha:" + this.senha);
    }
    public Usuario mostrarUsuarios(String Usuario, String Senha){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("usuario");
        busca.addItem("nome", Usuario);
        busca.addItem("senha", Senha);
        ArrayList<Dados> Resposta = banco.mostrarSQL(busca);
        if(Resposta.isEmpty()){
            return null;
        }
        Usuario user = new Usuario();
        user.setNomeUsuario(Resposta.get(0).getVarchar("nome"));
        user.setSenha(Resposta.get(0).getVarchar("senha"));
        
        return user;
    }
    
}
