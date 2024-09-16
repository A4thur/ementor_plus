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
public class Aluno extends Pessoa {
    private String matricula, turma;
    private int periodo;
    private boolean finalizado;

    public Aluno(String matricula, int periodo, String turma, boolean finalizado, String nome, String dataNascimento, String cpf, String telefone, String rua, String bairro, String cidade, String estado) {
        super(nome, dataNascimento, cpf, telefone, rua, bairro, cidade, estado);
        this.matricula = matricula;
        this.periodo = periodo;
        this.turma = turma;
        this.finalizado = finalizado;
    }
    
    public Aluno(){
        super();
        this.matricula = "";
        this.periodo = 0;
        this.turma = "";
        this.finalizado = false;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    
    public void setAluno(Aluno aluno){
        this.setMatricula(aluno.getMatricula());
        this.setPeriodo(aluno.getPeriodo());
        this.setFinalizado(aluno.isFinalizado());
        this.setTurma(aluno.getTurma());
    }
    
    public void imprimir(){
        super.imprimir();
        System.out.println("Matricula: "+this.matricula);
        System.out.println("Periodo: "+this.periodo);
        System.out.println("Turma: "+this.turma);
        System.out.println("Finalizou: "+this.finalizado);
    }
    
    public void inserir(){
        try{
            if(this.verificaAluno(this.cpf)) throw new SQLDuplicateException();
            super.inserir();
            Conexoes banco = new Conexoes();
            Dados aluno = new Dados("aluno");
            aluno.addItem("matricula", this.matricula);
            aluno.addItem("periodo", this.periodo);
            aluno.addItem("finalizado", this.finalizado);
            aluno.addItem("pessoaCPF", this.getCpf());
            banco.insereSQL(aluno);
        }catch(SQLDuplicateException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void atualiza(String CPF){
        try{
            if(!this.verificaAluno(CPF)) throw new SQLPresencaException();
            super.atualiza(CPF);
            Conexoes banco = new Conexoes();
            Dados aluno = new Dados("aluno");
            Dados busca = new Dados("aluno");
            aluno.addItem("matricula", this.matricula);
            aluno.addItem("periodo", this.periodo);
            aluno.addItem("finalizado", this.finalizado);
            busca.addItem("pessoaCPF", CPF);
            banco.atualizaSQL(aluno, busca);
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void exclui(String CPF){
        try{
            if(!this.verificaAluno(CPF)) throw new SQLPresencaException();
            Conexoes banco = new Conexoes();
            Dados busca = new Dados("aluno");
            busca.addItem("pessoaCPF", CPF);
            banco.exclusaoSQL(busca);
            super.exclui(CPF);
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Aluno> mostrarAlunos(String CPF){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("aluno");
        busca.addItem("pessoaCPF", CPF);
        ArrayList<Dados> Resposta = banco.mostrarSQL(busca);
        
        ArrayList<Pessoa> pessoas = this.mostrarPessoas(CPF);
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        for(int i = 0; i<Resposta.size(); i++){
            Aluno aluno = new Aluno();
            aluno.setMatricula(Resposta.get(i).getVarchar("matricula"));
            aluno.setPeriodo(Resposta.get(i).getInt("periodo"));
            aluno.setFinalizado(Resposta.get(i).getBool("finalizado"));
            aluno.setPessoa(pessoas.get(i));
            alunos.add(aluno);
        }
        return alunos;
    }
    
    public ArrayList<Aluno> mostrarAlunos(){
        Conexoes banco = new Conexoes();
        ArrayList<Dados> Resposta = banco.mostrarSQL("aluno");
        
        ArrayList<Pessoa> pessoas = this.mostrarPessoas();
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        for(int i = 0; i<Resposta.size(); i++){
            Aluno aluno = new Aluno();
            aluno.setMatricula(Resposta.get(i).getVarchar("matricula"));
            aluno.setPeriodo(Resposta.get(i).getInt("periodo"));
            aluno.setFinalizado(Resposta.get(i).getBool("finalizado"));
            aluno.setPessoa(pessoas.get(i));
            alunos.add(aluno);
        }
        return alunos;
    }
    
    public boolean verificaAluno(String CPF){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("aluno");
        busca.addItem("pessoaCPF", CPF);
        boolean resposta = banco.verificaOcorrencia(busca);
        return resposta;
    }
}
