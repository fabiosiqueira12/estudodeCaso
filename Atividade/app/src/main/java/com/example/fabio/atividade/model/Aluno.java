package com.example.fabio.atividade.model;

/**
 * Created by 151091852 on 17/09/2016.
 */
public class Aluno {

    private String nome;
    private String matricula;
    private String sexo;
    private String curso;
    private String periodoAtual;
    private boolean necessidadeEspecial;
    private String faculdade;

    public Aluno( String nome, String matricula, String sexo, String curso, String periodoAtual, boolean necessidadeEspecial, String faculdade) {

        this.nome = nome;
        this.matricula = matricula;
        this.sexo = sexo;
        this.curso = curso;
        this.periodoAtual = periodoAtual;
        this.necessidadeEspecial = necessidadeEspecial;
        this.faculdade = faculdade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getPeriodoAtual() {
        return periodoAtual;
    }

    public void setPeriodoAtual(String periodoAtual) {
        this.periodoAtual = periodoAtual;
    }

    public boolean isNecessidadeEspecial() {
        return necessidadeEspecial;
    }

    public void setNecessidadeEspecial(boolean necessidadeEspecial) {
        this.necessidadeEspecial = necessidadeEspecial;
    }

    public String getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(String faculdade) {
        this.faculdade = faculdade;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", sexo='" + sexo + '\'' +
                ", curso='" + curso + '\'' +
                ", periodoAtual='" + periodoAtual + '\'' +
                ", necessidadeEspecial=" + necessidadeEspecial +
                ", faculdade='" + faculdade + '\'' +
                '}';
    }
}
