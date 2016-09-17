package com.example.fabio.atividade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fabio.atividade.model.Pessoa;
import com.example.fabio.atividade.repositorio.RepositorioPessoa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editLogin;
    private EditText editSenha;
    private Button botaoLogin;
    private Pessoa pessoa = new Pessoa("123@gmail.com","123");
    private RepositorioPessoa repositorioPessoa = RepositorioPessoa.getInstancia();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLogin = (EditText) findViewById(R.id.texto_login);
        editSenha = (EditText) findViewById(R.id.texto_senha);
        botaoLogin = (Button) findViewById(R.id.botao_login);


        botaoLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

            if (!editLogin.getText().toString().equals("")) {

                if (!editSenha.getText().toString().equals("")) {


                        boolean pessoaLogada = repositorioPessoa.verificaLogin(editLogin.getText().toString(),editSenha.getText().toString());

                        if (pessoaLogada) {
                            Intent intent = new Intent(this, Main2Activity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(this, "Login ou senha inválido", Toast.LENGTH_SHORT).show();
                            editLogin.setText("");
                            editSenha.setText("");
                        }



                } else {
                    Toast.makeText(this, "Digite uma senha", Toast.LENGTH_SHORT).show();
                    }

            }else {
                Toast.makeText(this, "Digite um login", Toast.LENGTH_SHORT).show();
            }


    }
}
