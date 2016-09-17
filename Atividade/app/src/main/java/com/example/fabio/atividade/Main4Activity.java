package com.example.fabio.atividade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fabio.atividade.listadapter.MyRecyclerViewAdapter;
import com.example.fabio.atividade.repositorio.RepositorioAluno;

public class Main4Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private RepositorioAluno repositorioAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        this.init();
    }


    private void init(){
        this.recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        this.repositorioAluno = RepositorioAluno.getInstancia();
        this.myRecyclerViewAdapter = new MyRecyclerViewAdapter(this,repositorioAluno.retornaLista());


        this.recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        this.recyclerView.setAdapter(this.myRecyclerViewAdapter);

    }
}
