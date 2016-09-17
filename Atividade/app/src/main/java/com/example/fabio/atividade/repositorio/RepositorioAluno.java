package com.example.fabio.atividade.repositorio;

import com.example.fabio.atividade.model.Aluno;
import com.example.fabio.atividade.model.Pessoa;

import java.util.ArrayList;

/**
 * Created by 151091852 on 17/09/2016.
 */
public class RepositorioAluno {

    private static RepositorioAluno instancia;
    private ArrayList<Aluno> listaAlunos;


    private RepositorioAluno(){
        listaAlunos = new ArrayList<>();

    }

    public static RepositorioAluno getInstancia(){
        if (instancia == null){
            synchronized (RepositorioPessoa.class){
                if (instancia == null){
                    instancia = new RepositorioAluno();
                }
            }
        }

        return instancia;
    }



    public void adicionarPessoa(Aluno a){
        this.listaAlunos.add(a);
    }

    public ArrayList<Aluno> retornaLista(){
        return this.listaAlunos;
    }

}
