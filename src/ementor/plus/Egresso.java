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
public class Egresso extends Aluno{
    private String profissao, faixaSalarial, cursoAnterior, cursoAtual;

    public Egresso(String profissao, String faixaSalarial, String cursoAnterior, String cursoAtual, String matricula, int periodo, String turma, 
            boolean finalizado, String nome, String dataNascimento, String cpf, String telefone, String rua, String bairro, String cidade, String estado) {
        super(matricula, periodo, turma, finalizado, nome, dataNascimento, cpf, telefone, rua, bairro, cidade, estado);
        this.profissao = profissao;
        this.faixaSalarial = faixaSalarial;
        this.cursoAnterior = cursoAnterior;
        this.cursoAtual = cursoAtual;
    }
    
    public Egresso() {
        super();
        this.profissao = "";
        this.faixaSalarial = "";
        this.cursoAnterior = "";
        this.cursoAtual = "";
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getFaixaSalarial() {
        return faixaSalarial;
    }

    public void setFaixaSalarial(String faixaSalarial) {
        this.faixaSalarial = faixaSalarial;
    }

    public String getCursoAnterior() {
        return cursoAnterior;
    }

    public void setCursoAnterior(String cursoAnterior) {
        this.cursoAnterior = cursoAnterior;
    }

    public String getCursoAtual() {
        return cursoAtual;
    }

    public void setCursoAtual(String cursoAtual) {
        this.cursoAtual = cursoAtual;
    }
    
    public void inserir(){
        try{
            if(this.verificaEgresso(this.cpf)) throw new SQLDuplicateException();
            super.inserir();
            Conexoes banco = new Conexoes();
            Dados egresso = new Dados("egresso");
            egresso.addItem("profissao", this.profissao);
            egresso.addItem("faixaSalarial", this.faixaSalarial);
            egresso.addItem("cursoAnterior", this.cursoAnterior);
            egresso.addItem("cursoAtual", this.cursoAtual);            
            egresso.addItem("alunoCPF", this.getCpf());
            banco.insereSQL(egresso);
        }catch(SQLDuplicateException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void atualiza(String CPF){
        try{
            if(!this.verificaEgresso(CPF)) throw new SQLPresencaException();
            super.atualiza(CPF);
            Conexoes banco = new Conexoes();
            Dados egresso = new Dados("egresso");
            Dados busca = new Dados("egresso");
            egresso.addItem("profissao", this.profissao);
            egresso.addItem("faixaSalarial", this.faixaSalarial);
            egresso.addItem("cursoAnterior", this.cursoAnterior);
            egresso.addItem("cursoAtual", this.cursoAtual); 
            busca.addItem("alunoCPF", CPF);
            banco.atualizaSQL(egresso, busca);
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void exclui(String CPF){
        try{
            if(!this.verificaEgresso(CPF)) throw new SQLPresencaException();
            Conexoes banco = new Conexoes();
            Dados busca = new Dados("egresso");
            busca.addItem("alunoCPF", CPF);
            banco.exclusaoSQL(busca);
            super.exclui(CPF);
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Egresso> mostrarEgressos(String CPF){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("egresso");
        busca.addItem("alunoCPF", CPF);
        ArrayList<Dados> Resposta = banco.mostrarSQL(busca);
        
        ArrayList<Pessoa> pessoas = this.mostrarPessoas(CPF);
        ArrayList<Aluno> alunos = this.mostrarAlunos(CPF);
        ArrayList<Egresso> egressos = new ArrayList<Egresso>();
        
        for(int i = 0; i<Resposta.size(); i++){
            Egresso egresso = new Egresso();
            
            egresso.setProfissao(Resposta.get(i).getVarchar("profissao"));
            egresso.setFaixaSalarial(Resposta.get(i).getVarchar("faixaSalarial"));
            egresso.setCursoAnterior(Resposta.get(i).getVarchar("cursoAnterior"));
            egresso.setCursoAtual(Resposta.get(i).getVarchar("cursoAtual"));
            egresso.setAluno(alunos.get(i));
            egresso.setPessoa(pessoas.get(i));
            egressos.add(egresso);
        }
        return egressos;
    }
    
    public ArrayList<Egresso> mostrarEgressos(){
        Conexoes banco = new Conexoes();
        ArrayList<Dados> Resposta = banco.mostrarSQL("egresso");
        
       ArrayList<Pessoa> pessoas = this.mostrarPessoas();
        ArrayList<Aluno> alunos = this.mostrarAlunos();
        ArrayList<Egresso> egressos = new ArrayList<Egresso>();
        
        for(int i = 0; i<Resposta.size(); i++){
            Egresso egresso = new Egresso();
            
            egresso.setProfissao(Resposta.get(i).getVarchar("profissao"));
            egresso.setFaixaSalarial(Resposta.get(i).getVarchar("faixaSalarial"));
            egresso.setCursoAnterior(Resposta.get(i).getVarchar("cursoAnterior"));
            egresso.setCursoAtual(Resposta.get(i).getVarchar("cursoAtual"));
            egresso.setAluno(alunos.get(i));
            egresso.setPessoa(pessoas.get(i));
            egressos.add(egresso);
        }
        return egressos;
    }
    
    public boolean verificaEgresso(String CPF){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("egresso");
        busca.addItem("alunoCPF", CPF);
        boolean resposta = banco.verificaOcorrencia(busca);
        return resposta;
    }
    
}
