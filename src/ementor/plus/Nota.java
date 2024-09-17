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
public class Nota {
    private int avaliacao, alunoTurmaid;
    private float nota;

    public Nota(int avaliacao, int alunoTurmaid, float nota) {
        this.avaliacao = avaliacao;
        this.alunoTurmaid = alunoTurmaid;
        this.nota = nota;
    }
    
    public Nota(float nota) {
        this.avaliacao = 0;
        this.alunoTurmaid = 0;
        this.nota = nota;
    }
    
    public Nota() {
        this.avaliacao = 0;
        this.alunoTurmaid = 0;
        this.nota = 0;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getAlunoTurmaid() {
        return alunoTurmaid;
    }

    public void setAlunoTurmaid(int alunoTurmaid) {
        this.alunoTurmaid = alunoTurmaid;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
    public void inserir(){
        try{
            if(this.verificaAlunoTurma(this.alunoTurmaid,this.avaliacao)) throw new SQLDuplicateException();
            AlunoTurma alunoTurma = new AlunoTurma();
            if(!alunoTurma.verificaAlunoTurma(this.alunoTurmaid)) throw new SQLPresencaException();
            Conexoes banco = new Conexoes();
            Dados nota = new Dados("aluno_turma_nota");
            nota.addItem("alunoTurmaId", this.alunoTurmaid);
            nota.addItem("nota", this.nota);
            nota.addItem("avaliacao", this.avaliacao);
            banco.insereSQL(nota);
        }catch(SQLDuplicateException | SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void atualiza(int id, int avaliacao){
        try{    
            if(!this.verificaAlunoTurma(id, avaliacao)) throw new SQLPresencaException();
            Conexoes banco = new Conexoes();
            AlunoTurma alunoTurma = new AlunoTurma();
            Dados notas = new Dados("aluno_turma_nota");
            Dados busca = new Dados("aluno_turma_nota");
            notas.addItem("nota", this.nota);
            busca.addItem("alunoTurmaId", id);
            busca.addItem("avaliacao", avaliacao);
            banco.atualizaSQL(notas, busca);
            alunoTurma.atualizaMedia(id);
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Nota> mostrarNota(int id){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("aluno_turma_nota");
        busca.addItem("alunoTurmaId", id);
        ArrayList<Dados> Resposta = banco.mostrarSQL(busca);
        ArrayList<Nota> notas = new ArrayList<Nota>();
        try{
            if(Resposta.isEmpty()) throw new SQLPresencaException();
            for(int i = 0; i<Resposta.size(); i++){
                Nota nota = new Nota();
                nota.setAlunoTurmaid(Resposta.get(i).getInt("alunoTurmaId"));
                nota.setNota(Resposta.get(i).getFloat("nota"));
                nota.setAvaliacao(Resposta.get(i).getInt("avaliacao"));
                notas.add(nota);
            }
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return notas;
    }
    
    public boolean verificaAlunoTurma(int id, int avaliacao){
        Conexoes banco = new Conexoes();
        Dados busca = new Dados("aluno_turma_nota");
        busca.addItem("alunoTurmaId", id);
        busca.addItem("avaliacao", avaliacao);
        boolean resposta = banco.verificaOcorrencia(busca);
        return resposta;
    }
    public void excluirNotas(int id){
        try{
            if(!this.verificaAlunoTurma(id, avaliacao)) throw new SQLPresencaException();
            Conexoes banco = new Conexoes();
            Dados busca = new Dados("aluno_turma_nota");
            busca.addItem("alunoTurmaId", id);
            banco.exclusaoSQL(busca);
        }catch(SQLPresencaException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
}
