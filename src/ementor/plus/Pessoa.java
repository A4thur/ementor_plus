/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ementor.plus;

import ementor.plus.LogErros.SQLDuplicateException;
import ementor.plus.LogErros.SQLPresencaException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Pessoa {
    protected String nome, dataNascimento, cpf,telefone,rua,bairro,cidade,estado;

    public Pessoa(String nome, String dataNascimento, String cpf, String telefone, String rua, String bairro, String cidade, String estado) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    public Pessoa(){
        this.nome = "";
        this.dataNascimento = "";
        this.cpf = "";
        this.telefone = "";
        this.rua = "";
        this.bairro = "";
        this.cidade = "";
        this.estado = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setPessoa(Pessoa pessoa){
        this.nome = pessoa.nome;
        this.dataNascimento = pessoa.dataNascimento;
        this.cpf = pessoa.cpf;
        this.telefone = pessoa.telefone;
        this.rua = pessoa.rua;
        this.bairro = pessoa.bairro;
        this.cidade = pessoa.cidade;
        this.estado = pessoa.estado;
    }
    
    public void imprimir(){
        System.out.println("Nome: "+this.nome);
        System.out.println("Data de nascimento: "+this.dataNascimento);
        System.out.println("CPF: "+this.cpf);
        System.out.println("Telefone: "+this.telefone);
        System.out.println("Rua: "+this.rua);
        System.out.println("Bairro: "+this.bairro);
        System.out.println("Cidade: "+this.cidade);
        System.out.println("Estado: "+this.estado);
    }
    
    public void inserir(){
        try{
            if(this.verificaPessoa(this.cpf)) throw new SQLDuplicateException();
            Conexoes banco = new Conexoes();
            Dados pessoa = new Dados("pessoa");
            pessoa.addItem("nome", this.nome);
            pessoa.addItem("dataN", this.dataNascimento);
            pessoa.addItem("CPF", this.cpf);
            pessoa.addItem("telefone", this.telefone);
            pessoa.addItem("rua", this.rua);
            pessoa.addItem("bairro", this.bairro);
            pessoa.addItem("cidade", this.cidade);
            pessoa.addItem("uf", this.estado);
            banco.insereSQL(pessoa);
        }catch(SQLDuplicateException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void atualiza(String CPF){
        try{
            if(!this.verificaPessoa(CPF)) throw new SQLPresencaException();
            Conexoes banco = new Conexoes();
            Dados pessoa = new Dados("pessoa");
            Dados busca = new Dados("pessoa");
            pessoa.addItem("nome", this.nome);
            pessoa.addItem("dataN", this.dataNascimento);
            pessoa.addItem("telefone", this.telefone);
            pessoa.addItem("rua", this.rua);
            pessoa.addItem("bairro", this.bairro);
            pessoa.addItem("cidade", this.cidade);
            pessoa.addItem("uf", this.estado);
            busca.addItem("CPF", CPF);
            banco.atualizaSQL(pessoa, busca);
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void exclui(String CPF){
        try{
            if(!this.verificaPessoa(CPF)) throw new SQLPresencaException();
            Conexoes banco = new Conexoes();
            Dados busca = new Dados("pessoa");
            busca.addItem("CPF", CPF);
            banco.exclusaoSQL(busca);
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Pessoa> mostrarPessoas(String CPF){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("pessoa");
        busca.addItem("CPF", CPF);
        
        ArrayList<Dados> Resposta = banco.mostrarSQL(busca);
        
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        for(int i = 0; i<Resposta.size(); i++){
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(Resposta.get(i).getVarchar("nome"));
            pessoa.setDataNascimento(Resposta.get(i).getVarchar("dataN"));
            pessoa.setTelefone(Resposta.get(i).getVarchar("telefone"));
            pessoa.setRua(Resposta.get(i).getVarchar("rua"));
            pessoa.setBairro(Resposta.get(i).getVarchar("bairro"));
            pessoa.setCidade(Resposta.get(i).getVarchar("cidade"));
            pessoa.setEstado(Resposta.get(i).getVarchar("uf"));
            pessoa.setCpf(Resposta.get(i).getVarchar("CPF"));
            pessoas.add(pessoa);
        }
        
        return pessoas;
    }
    
    public ArrayList<Pessoa> mostrarPessoas(){
        Conexoes banco = new Conexoes();
        
        ArrayList<Dados> Resposta = banco.mostrarSQL("pessoa");
        
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        for(int i = 0; i<Resposta.size(); i++){
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(Resposta.get(i).getVarchar("nome"));
            pessoa.setDataNascimento(Resposta.get(i).getVarchar("dataN"));
            pessoa.setTelefone(Resposta.get(i).getVarchar("telefone"));
            pessoa.setRua(Resposta.get(i).getVarchar("rua"));
            pessoa.setBairro(Resposta.get(i).getVarchar("bairro"));
            pessoa.setCidade(Resposta.get(i).getVarchar("cidade"));
            pessoa.setEstado(Resposta.get(i).getVarchar("uf"));
            pessoa.setCpf(Resposta.get(i).getVarchar("CPF"));
            pessoas.add(pessoa);
        }
        return pessoas;
    }
    
    public boolean verificaPessoa(String CPF){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("pessoa");
        busca.addItem("CPF", CPF);
        boolean resposta = banco.verificaOcorrencia(busca);
        return resposta;
    }
}
