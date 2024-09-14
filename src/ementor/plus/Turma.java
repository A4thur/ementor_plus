/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ementor.plus;

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
    
}
