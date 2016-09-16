package com.example.fabio.atividade3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.example.fabio.atividade3.listLayout.ITouchHelperAdapter;
import com.example.fabio.atividade3.listLayout.ItemTouchRecycleView;
import com.example.fabio.atividade3.listLayout.MyRecyclerViewAdapter;
import com.example.fabio.atividade3.model.Filme;
import com.example.fabio.atividade3.repositorio.RepositorioFilme;

import java.util.ArrayList;


    public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private RepositorioFilme repositorioFilme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
    }


    private void init(){


        this.recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        this.repositorioFilme = RepositorioFilme.getInstancia();

        System.out.println(this.repositorioFilme.retornaLista().size());

        this.myRecyclerViewAdapter = new MyRecyclerViewAdapter(this,this.repositorioFilme.retornaLista());
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        this.recyclerView.setAdapter(this.myRecyclerViewAdapter);


        ItemTouchHelper.Callback callback = new ItemTouchRecycleView(this.myRecyclerViewAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);



    }


    }
