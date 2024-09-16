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
public class Professor extends Pessoa{
    private String dataAdmissao;
    private float salario;
    private boolean chefia, coordenacao;

    public Professor(String dataAdmissao, boolean chefia, boolean coordenacao, float salario, String nome, String dataNascimento, String cpf, String telefone, String rua, String bairro, String cidade, String estado) {
        super(nome, dataNascimento, cpf, telefone, rua, bairro, cidade, estado);
        this.dataAdmissao = dataAdmissao;
        this.chefia = chefia;
        this.coordenacao = coordenacao;
        this.salario = salario;
    }
 
    public Professor(){
        super();
        this.dataAdmissao = "";
        this.chefia = false;
        this.coordenacao = false;
        this.salario = 0.0f;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public boolean getChefia() {
        return chefia;
    }

    public void setChefia(boolean chefia) {
        this.chefia = chefia;
    }

    public boolean getCoordenacao() {
        return coordenacao;
    }

    public void setCoordenacao(boolean coordenacao) {
        this.coordenacao = coordenacao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    public void imprimir(){
        super.imprimir();
        System.out.println("Nome: "+this.dataAdmissao);
        System.out.println("Nome: "+this.chefia);
        System.out.println("Nome: "+this.coordenacao);
        System.out.println("Nome: "+this.salario);
    }
    
    public double calculaBruto(){
        double adicionalChefia = 0.3;
        double adicionalCoordenacao = 0.2;
        return this.getSalario()*(1+adicionalChefia+adicionalCoordenacao);
    }
    
    public double calculaLiquido(){
        if(this.getSalario() < 5000.0){
            return this.getSalario() * 0.86;
        }
        return this.getSalario() * 0.635;
    }
    
    public void inserir(){
        try{
            if(this.verificaProfessor(this.cpf)) throw new SQLDuplicateException();
            super.inserir();
            Conexoes banco = new Conexoes();
            Dados professor = new Dados("professor");
            professor.addItem("dataAdmicao", this.dataAdmissao);
            professor.addItem("chefia", this.chefia);
            professor.addItem("coordenacao", this.coordenacao);
            professor.addItem("salarioBruto", this.salario);
            professor.addItem("pessoaCPF", this.getCpf());
            banco.insereSQL(professor);
        }catch(SQLDuplicateException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void atualiza(String CPF){
        try{
            if(!this.verificaProfessor(CPF)) throw new SQLPresencaException();
            super.atualiza(CPF);
            Conexoes banco = new Conexoes();
            Dados professor = new Dados("professor");
            Dados busca = new Dados("professor");
            professor.addItem("dataAdmicao", this.dataAdmissao);
            professor.addItem("chefia", this.chefia);
            professor.addItem("coordenacao", this.coordenacao);
            professor.addItem("salarioBruto", this.salario);
            busca.addItem("pessoaCPF", CPF);
            banco.atualizaSQL(professor, busca);
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void exclui(String CPF){
        try{
            if(!this.verificaProfessor(CPF)) throw new SQLPresencaException();
            Conexoes banco = new Conexoes();
            Dados busca = new Dados("professor");
            busca.addItem("pessoaCPF", CPF);
            banco.exclusaoSQL(busca);
            super.exclui(CPF);
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Professor> mostrarProfessor(String CPF){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("professor");
        busca.addItem("pessoaCPF", CPF);
        ArrayList<Dados> Resposta = banco.mostrarSQL(busca);
        ArrayList<Pessoa> pessoas = this.mostrarPessoas(CPF);
        
        ArrayList<Professor> professores = new ArrayList<Professor>();
        for(int i = 0; i<Resposta.size(); i++){
            Professor professor = new Professor();
            professor.setDataAdmissao(Resposta.get(i).getVarchar("dataAdmicao"));
            professor.setChefia(Resposta.get(i).getBool("chefia"));
            professor.setCoordenacao(Resposta.get(i).getBool("coordenacao"));
            professor.setSalario(Resposta.get(i).getFloat("salarioBruto"));
            professor.setPessoa(pessoas.get(i));
            professores.add(professor);
        }
        return professores;
    }
    
    public ArrayList<Professor> mostrarProfessor(){
        Conexoes banco = new Conexoes();
        ArrayList<Dados> Resposta = banco.mostrarSQL("professor");
        
        
        ArrayList<Professor> professores = new ArrayList<Professor>();
        for(int i = 0; i<Resposta.size(); i++){
            Professor professor = new Professor();
            professor.setDataAdmissao(Resposta.get(i).getVarchar("dataAdmicao"));
            professor.setChefia(Resposta.get(i).getBool("chefia"));
            professor.setCoordenacao(Resposta.get(i).getBool("coordenacao"));
            professor.setSalario(Resposta.get(i).getFloat("salarioBruto"));
            ArrayList<Pessoa> pessoas = this.mostrarPessoas(Resposta.get(i).getVarchar("pessoaCPF"));
            professor.setPessoa(pessoas.get(0));
            professores.add(professor);
        }
        return professores;
    }
    
    public boolean verificaProfessor(String CPF){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("professor");
        busca.addItem("pessoaCPF", CPF);
        boolean resposta = banco.verificaOcorrencia(busca);
        return resposta;
    }
}
