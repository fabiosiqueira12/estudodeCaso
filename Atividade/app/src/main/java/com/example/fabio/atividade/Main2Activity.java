package com.example.fabio.atividade;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    private Intent intent;
   private   Button botaoSalvar;
    private  Button botaoListar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        botaoListar = (Button) findViewById(R.id.botao_listar);
        botaoSalvar = (Button) findViewById(R.id.botao_cadastrar);

        botaoListar.setOnClickListener(this);
        botaoSalvar.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.botao_listar):
                intent = new Intent(this,Main4Activity.class);
                startActivity(intent);
                    break;
            case (R.id.botao_cadastrar):
                intent = new Intent(this,Main3Activity.class);
                startActivity(intent);
                break;
            }
        }



}

