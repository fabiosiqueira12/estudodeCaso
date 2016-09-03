package com.example.fabio.atividade2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabio.atividade2.model.Pessoa;

public class Main2Activity extends AppCompatActivity {

    EditText nomeGet;
    EditText emailGet;
    EditText idadeGet;
    EditText sexoGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        nomeGet = (EditText) findViewById(R.id.nome_get);
        emailGet = (EditText) findViewById(R.id.email_get);
        idadeGet = (EditText) findViewById(R.id.idade_get);
        sexoGet = (EditText) findViewById(R.id.sexo_get);


        Intent intent = getIntent();

        Pessoa pessoa = (Pessoa) intent.getSerializableExtra("pessoa");

        if (pessoa != null){

            nomeGet.setText(pessoa.getNome());
            emailGet.setText(pessoa.getEmail());
            idadeGet.setText(String.valueOf(pessoa.getIdade()) + " Anos");
            sexoGet.setText(pessoa.getSexo());


        } else {
            Toast.makeText(this,"ERRO",Toast.LENGTH_LONG).show();
        }




    }
}
