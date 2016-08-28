package com.example.fabio.atividade1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Objetos
    Button abriAcompanhamento;
    Button abriNoticias;
    Button abriContato;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        abriAcompanhamento = (Button) findViewById(R.id.botao1);
        abriAcompanhamento.setOnClickListener(this);
        abriNoticias = (Button) findViewById(R.id.botao2);
        abriNoticias.setOnClickListener(this);
        abriContato = (Button) findViewById(R.id.botao3);
        abriContato.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.botao1:
                intent = new Intent(this,AcompanhamentoActivity.class);
                startActivity(intent);
                 break;
            case R.id.botao2:
                intent = new Intent(this,NoticiaActivity.class);
                startActivity(intent);
                break;
            case R.id.botao3:
                intent = new Intent(this,ContatoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
