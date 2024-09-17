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
 * @author carlo
 */
public class AlunoTurma {
    private String alunoCPF, codigoTurma;
    private float notaMedia;

    public AlunoTurma(String alunoCPF, String codigoTurma) {
        this.alunoCPF = alunoCPF;
        this.codigoTurma = codigoTurma;
        this.notaMedia = 0f;
    }
    public AlunoTurma() {
        this.alunoCPF = "";
        this.codigoTurma = "";
        this.notaMedia = 0f;
    }

    public String getAlunoCPF() {
        return alunoCPF;
    }

    public void setAlunoCPF(String alunoCPF) {
        this.alunoCPF = alunoCPF;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public float getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(float notaMedia) {
        this.notaMedia = notaMedia;
    }
    
    
    
    public void inserir(){
        int id;
        try{
            if(this.verificaAlunoTurma(this.codigoTurma, this.alunoCPF)) throw new SQLDuplicateException();
            Turma Turma = new Turma();
            Aluno aluno = new Aluno();
            if(!(Turma.verificaTurma(this.codigoTurma) && aluno.verificaAluno(this.alunoCPF))) throw new SQLPresencaException();
            Conexoes banco = new Conexoes();
            Dados alunoTurma = new Dados("aluno_turma");
            Dados busca = new Dados("aluno_turma");
            busca.addItem("codigoTurma", this.codigoTurma);
            busca.addItem("alunoCPF", this.alunoCPF);
            alunoTurma.addItem("codigoTurma", this.codigoTurma);
            alunoTurma.addItem("alunoCPF", this.alunoCPF);
            alunoTurma.addItem("notaMedia", this.notaMedia);
            banco.insereSQL(alunoTurma);
            id = banco.mostrarSQLId(busca);
            Turma turma = new Turma();
            turma.mostraTurma(this.codigoTurma);
            for(int i = 0;i<turma.getnAvaliacoes();i++){
                Nota nota = new Nota();
                nota.setAlunoTurmaid(id);
                nota.setAvaliacao(i);
                nota.setNota(0f);
                nota.inserir();
            }
        }catch(SQLDuplicateException | SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void atualizaMedia(int id){
        Nota nota = new Nota();
        ArrayList<Nota> notas = nota.mostrarNota(id);
        Conexoes banco = new Conexoes();
        Dados dados = new Dados("aluno_turma");
        Dados busca = new Dados("aluno_turma");
        float somaNota = 0f;
        int numNotas = 0;
        float media = 0;
        for(int i = 0; i< notas.size(); i++){
            somaNota = somaNota + notas.get(i).getNota();
            numNotas++;
        }
        media = somaNota/numNotas;
        busca.addItem("id", id);
        dados.addItem("notaMedia", media);
        banco.atualizaSQL(dados, busca);
    }
    
    public void exclui(String turma, String cpf){
        int id;
        try{
            if(!this.verificaAlunoTurma(turma, cpf)) throw new SQLPresencaException();
            Conexoes banco = new Conexoes();
            Dados busca = new Dados("aluno_turma");
            Dados Item = new Dados("aluno_turma");
            busca.addItem("alunoCPF", cpf);
            busca.addItem("codigoTurma", turma);
            id = banco.mostrarSQLId(busca);
            banco.exclusaoSQL(busca);
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<AlunoTurma> mostrarAlunoTurma(String cpf){
        Conexoes banco = new Conexoes();
        Dados Busca = new Dados("aluno_turma");
        Busca.addItem("alunoCPF", cpf);
        ArrayList<Dados> Resposta = banco.mostrarSQL(Busca);
        ArrayList<AlunoTurma> alunoTurma = new ArrayList();
        try{
            if(Resposta.isEmpty()) throw new SQLPresencaException();
            for(int i = 0; i < Resposta.size(); i++){
                AlunoTurma aluno = new AlunoTurma();
                aluno.setAlunoCPF(Resposta.get(i).getVarchar("alunoCPF"));
                aluno.setCodigoTurma(Resposta.get(i).getVarchar("codigoTurma"));
                aluno.setNotaMedia(Resposta.get(i).getFloat("notaMedia"));
                alunoTurma.add(aluno);
            }
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return alunoTurma;
    }
    
    public ArrayList<AlunoTurma> mostrarCodigoTurma(String codigo){
        Conexoes banco = new Conexoes();
        Dados Busca = new Dados("aluno_turma");
        Busca.addItem("codigoTurma", codigo);
        ArrayList<Dados> Resposta = banco.mostrarSQL(Busca);
        ArrayList<AlunoTurma> alunoTurma = new ArrayList();
        try{
            if(Resposta.isEmpty()) throw new SQLPresencaException();
            for(int i = 0; i < Resposta.size(); i++){
                AlunoTurma aluno = new AlunoTurma();
                aluno.setAlunoCPF(Resposta.get(i).getVarchar("alunoCPF"));
                aluno.setCodigoTurma(Resposta.get(i).getVarchar("codigoTurma"));
                aluno.setNotaMedia(Resposta.get(i).getFloat("notaMedia"));
                alunoTurma.add(aluno);
            }
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return alunoTurma;
    }
    
    public int AlunoTurmaId(String cpf, String codigo){
        Conexoes banco = new Conexoes();
        Dados Busca = new Dados("aluno_turma");
        Busca.addItem("alunoCPF", cpf);
        ArrayList<Dados> Resposta = banco.mostrarSQL(Busca);
        int id = 0;
        try{
            if(Resposta.isEmpty()) throw new SQLPresencaException();
            id = Resposta.get(0).getInt("id");
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }
    
    public AlunoTurma mostrarAlunoTurmaId(int id){
        Conexoes banco = new Conexoes();
        Dados Busca = new Dados("aluno_turma");
        Busca.addItem("id", id);
        ArrayList<Dados> Resposta = banco.mostrarSQL(Busca);
        AlunoTurma aluno = new AlunoTurma();
        try{
            if(Resposta.isEmpty()) throw new SQLPresencaException();
            aluno.setAlunoCPF(Resposta.get(0).getVarchar("alunoCPF"));
            aluno.setCodigoTurma(Resposta.get(0).getVarchar("codigoTurma"));
            aluno.setNotaMedia(Resposta.get(0).getFloat("notaMedia"));
            
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return aluno;
    }
    
    public boolean verificaAlunoTurma(String Turma, String Aluno){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("aluno_turma");
        busca.addItem("codigoTurma", Turma);
        busca.addItem("alunoCPF", Aluno);
        boolean resposta = banco.verificaOcorrencia(busca);
        return resposta;
    }
    
    public boolean verificaAlunoTurma(int id){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("aluno_turma");
        busca.addItem("id", id);
        boolean resposta = banco.verificaOcorrencia(busca);
        return resposta;
    }
    public void atualizaId(int id){
        try{
            if(!this.verificaAlunoTurma(id)) throw new SQLPresencaException();
            Conexoes banco = new Conexoes();
            Dados dados = new Dados("aluno_turma");
            Dados busca = new Dados("aluno_turma");
            dados.addItem("codigoTurma", this.codigoTurma);
            dados.addItem("alunoCPF", this.alunoCPF);
            busca.addItem("id", id);
            banco.atualizaSQL(dados, busca);
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
}
