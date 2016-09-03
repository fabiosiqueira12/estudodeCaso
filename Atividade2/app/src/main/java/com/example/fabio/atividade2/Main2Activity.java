package com.example.fabio.atividade2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fabio.atividade2.model.Pessoa;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        Pessoa pessoa = (Pessoa) intent.getSerializableExtra("pessoa");
        if (pessoa != null){
            Toast.makeText(this,pessoa.toString(),Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"ERRO",Toast.LENGTH_LONG).show();
        }

    }
}
