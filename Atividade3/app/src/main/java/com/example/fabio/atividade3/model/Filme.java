package com.example.fabio.atividade3.model;

import java.io.Serializable;

/**
 * Created by fabio on 10/09/16.
 */
public class Filme implements Serializable{

    String nome;
    String categoria;
    String detalhes;
    int anoLancamento;

    public Filme(String nome, String categoria, String detalhes, int anoLancamento) {
        this.nome = nome;
        this.categoria = categoria;
        this.detalhes = detalhes;
        this.anoLancamento = anoLancamento;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

}//fimClasse
