package com.example.fabio.atividade.repositorio;

import com.example.fabio.atividade.model.Pessoa;

import java.util.ArrayList;

/**
 * Created by 151091852 on 17/09/2016.
 */
public class RepositorioPessoa {

    private static RepositorioPessoa instancia;
    private ArrayList<Pessoa> listaPessoas;


    private RepositorioPessoa(){
        listaPessoas = new ArrayList<>();
        this.adicionarAutomatico();
    }

    public static RepositorioPessoa getInstancia(){
        if (instancia == null){
            synchronized (RepositorioPessoa.class){
                if (instancia == null){
                    instancia = new RepositorioPessoa();
                }
            }
        }

        return instancia;
    }

    private void adicionarAutomatico(){

        if (this.listaPessoas.isEmpty()){
            for (int i = 0; i < 10; i++) {
                Pessoa p = new Pessoa("teste"+ (i+1),"senha"+ (i+1));
                this.listaPessoas.add(p);
            }

        }
    }


    public void adicionarPessoa(Pessoa p){
        this.listaPessoas.add(p);
    }

    public ArrayList<Pessoa> retornaLista(){
        return this.listaPessoas;
    }

    public boolean verificaLogin(String login, String senha){
        boolean pessoaLogada = false;
        for (Pessoa p: this.listaPessoas) {

            if (p.getLogin().equals(login) && p.getSenha().equals(senha)){
                pessoaLogada = true;
                break;
            }

        }

        return pessoaLogada;
    }



}
