package com.example.fabio.atividade.model;

/**
 * Created by 151091852 on 17/09/2016.
 */
public class Pessoa {

    protected String login;
    protected String senha;

    public Pessoa(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }


}
