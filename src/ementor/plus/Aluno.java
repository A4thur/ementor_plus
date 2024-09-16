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
public class Aluno extends Pessoa {
    private String matricula;
    private int periodo;
    private boolean finalizado;

    public Aluno(String matricula, int periodo, boolean finalizado, String nome, String dataNascimento, String cpf, String telefone, String rua, String bairro, String cidade, String estado) {
        super(nome, dataNascimento, cpf, telefone, rua, bairro, cidade, estado);
        this.matricula = matricula;
        this.periodo = periodo;
        this.finalizado = finalizado;
    }
    
    public Aluno(){
        super();
        this.matricula = "";
        this.periodo = 0;
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

    

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
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
        super.imprimir();
        System.out.println("Matricula: "+this.matricula);
        System.out.println("Periodo: "+this.periodo);
        System.out.println("Finalizou: "+this.finalizado);
    }
    
    public void inserir(){
        super.inserir();
        Conexoes banco = new Conexoes();
        Dados aluno = new Dados("aluno");
        aluno.addItem("matricula", this.matricula);
        aluno.addItem("periodo", this.periodo);
        aluno.addItem("finalizado", this.finalizado);
        aluno.addItem("pessoaCPF", this.getCpf());
        banco.insereSQL(aluno);
    }
    
    public void atualiza(String CPF){
        super.atualiza(CPF);
        Conexoes banco = new Conexoes();
        Dados aluno = new Dados("aluno");
        Dados busca = new Dados("aluno");
        aluno.addItem("matricula", this.matricula);
        aluno.addItem("periodo", this.periodo);
        aluno.addItem("finalizado", this.finalizado);
        busca.addItem("pessoaCPF", CPF);
        banco.atualizaSQL(aluno, busca);
    }
    
    public void exclui(String CPF){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("aluno");
        busca.addItem("pessoaCPF", CPF);
        banco.exclusaoSQL(busca);
        super.exclui(CPF);
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
}
