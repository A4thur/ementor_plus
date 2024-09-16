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
public class Turma {
    private String nome, codigo, professorResponsvel;
    private int nAvaliacoes;

    public Turma(String nome, String codigo, String professorResponsvel, int nAvaliacoes) {
        this.nome = nome;
        this.codigo = codigo;
        this.professorResponsvel = professorResponsvel;
        this.nAvaliacoes = nAvaliacoes;
    }

    
    public Turma(){
        this.nome = "";
        this.codigo = "";
        this.professorResponsvel = "";
        this.nAvaliacoes = 0;
    }

    public String getProfessorResponsvel() {
        return professorResponsvel;
    }

    public void setProfessorResponsvel(String professorResponsvel) {
        this.professorResponsvel = professorResponsvel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getnAvaliacoes() {
        return nAvaliacoes;
    }

    public void setnAvaliacoes(int nAvaliacoes) {
        this.nAvaliacoes = nAvaliacoes;
    }
    
    public void inserir(){
        try{
            if(this.verificaTurma(this.codigo)) throw new SQLDuplicateException();
            Professor professor = new Professor();
            if(!professor.verificaProfessor(this.professorResponsvel)) throw new SQLPresencaException();
            Conexoes banco = new Conexoes();
            Dados turma = new Dados("turma");
            turma.addItem("nome", this.nome);
            turma.addItem("professorCPF", this.professorResponsvel);
            turma.addItem("numAvaliacoes", this.nAvaliacoes);
            turma.addItem("codigo", this.codigo);
            banco.insereSQL(turma);
        }catch(SQLDuplicateException | SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void atualizar(String Codigo){
        try{
            if(!this.verificaTurma(Codigo)) throw new SQLPresencaException();
            Professor professor = new Professor();
            if(!professor.verificaProfessor(this.professorResponsvel)) throw new SQLPresencaException();
            Conexoes banco = new Conexoes();
            Dados turma = new Dados("turma");
            Dados busca = new Dados("turma");
            turma.addItem("nome", this.nome);
            turma.addItem("professorCPF", this.professorResponsvel);
            turma.addItem("numAvaliacoes", this.nAvaliacoes);
            turma.addItem("codigo", this.codigo);
            busca.addItem("codigo", Codigo);
            banco.atualizaSQL(turma, busca);
        }catch(SQLDuplicateException | SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void exclui(String Codigo){
        try{
            if(!this.verificaTurma(Codigo)) throw new SQLPresencaException();
            Conexoes banco = new Conexoes();
            Dados busca = new Dados("turma");
            busca.addItem("codigo", Codigo);
            banco.exclusaoSQL(busca);
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Turma mostraTurma(String codigo){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("turma");
        busca.addItem("codigo", codigo);
        ArrayList<Dados> Resposta = banco.mostrarSQL(busca);
        Turma turma = new Turma();
        try{
            if(Resposta.isEmpty()) throw new SQLPresencaException();
            turma.setCodigo(Resposta.get(0).getVarchar("codigo"));
            turma.setNome(Resposta.get(0).getVarchar("nome"));
            turma.setProfessorResponsvel(Resposta.get(0).getVarchar("professorCPF"));
            turma.setnAvaliacoes(Resposta.get(0).getInt("numAvaliacoes"));
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return turma;
    }
    
    public boolean verificaTurma(String Codigo){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("turma");
        busca.addItem("codigo", Codigo);
        boolean resposta = banco.verificaOcorrencia(busca);
        return resposta;
    }
    
}
