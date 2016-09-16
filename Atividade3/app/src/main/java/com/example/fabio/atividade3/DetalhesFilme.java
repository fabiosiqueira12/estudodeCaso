package com.example.fabio.atividade3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fabio.atividade3.model.Filme;

public class DetalhesFilme extends AppCompatActivity {

    private Intent intent;
    private TextView detalheFilme;
    private Filme filme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filme);
        this.init();


        this.detalheFilme.setText(String.valueOf(this.filme.getDetalhes()));

    }


    private void init(){
        this.intent = getIntent();
        this.filme = (Filme) intent.getSerializableExtra("filme");

        this.detalheFilme = (TextView) findViewById(R.id.detalhe_filme);
    }

}
