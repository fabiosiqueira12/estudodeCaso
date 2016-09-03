package com.example.fabio.atividade2.model;

import java.io.Serializable;

/**
 * Created by 151091852 on 03/09/2016.
 */
public class Pessoa implements Serializable {

    String nome;
    String email;
    String senha;
    String sexo;

    public Pessoa(String nome, String email, String senha,String sexo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
