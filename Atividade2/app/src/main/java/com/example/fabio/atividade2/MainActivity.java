package com.example.fabio.atividade2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fabio.atividade2.model.Pessoa;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nomeUsuario;
    EditText senhaUsuario;
    EditText emailUsuario;
    Button buttonSalvar;
    Button buttonLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeUsuario = (EditText) findViewById(R.id.nome_usuario);
        emailUsuario = (EditText) findViewById(R.id.email_usuario);
        senhaUsuario = (EditText) findViewById(R.id.senha_usuario);

        buttonSalvar = (Button) findViewById(R.id.button_salvar);
        buttonLimpar = (Button) findViewById(R.id.button_limpar);

        buttonSalvar.setOnClickListener(this);
        buttonLimpar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_limpar:

                nomeUsuario.setText("");
                emailUsuario.setText("");
                senhaUsuario.setText("");


                break;

            case R.id.button_salvar:

                String nome = nomeUsuario.getText().toString();
                String senha = senhaUsuario.getText().toString();
                String email = emailUsuario.getText().toString();

                Intent intent = new Intent(this,Main2Activity.class);

                intent.putExtra("pessoa", new Pessoa(nome,email,senha,"masculino"));

                startActivity(intent);

                break;
        }
    }
}
