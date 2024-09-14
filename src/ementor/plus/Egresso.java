/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ementor.plus;

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
    
}
