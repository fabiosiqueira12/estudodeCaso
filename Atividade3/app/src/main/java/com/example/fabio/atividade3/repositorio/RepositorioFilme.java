package com.example.fabio.atividade3.repositorio;

import com.example.fabio.atividade3.model.Filme;

import java.util.ArrayList;

/**
 * Created by fabio on 10/09/16.
 */
public class RepositorioFilme {

    private static RepositorioFilme instancia;
    private ArrayList<Filme> listaFilmes;


    public static RepositorioFilme getInstancia(){
        if (instancia == null){
            instancia = new RepositorioFilme();
        }

        return  instancia;
    }

    private RepositorioFilme(){
        this.listaFilmes = new ArrayList<>();
        this.adicionaFilmes();
    }

    private void adicionaFilmes(){

        if (this.listaFilmes.isEmpty()) {
            for (int i = 0; i < 50; i++) {
                Filme filme = new Filme("teste" + (i+1), "teste" + (i+1), "teste" + (i + 1), (i+1));

                this.listaFilmes.add(filme);

            }
        }

    }

    public ArrayList<Filme> retornaLista(){
        return this.listaFilmes;
    }


}
