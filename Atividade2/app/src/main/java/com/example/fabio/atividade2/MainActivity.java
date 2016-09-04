package com.example.fabio.atividade2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.fabio.atividade2.model.Pessoa;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener {

    EditText nomeUsuario;
    EditText senhaUsuario;
    EditText emailUsuario;
    Button buttonSalvar;
    Button buttonLimpar;
    RadioGroup radioGroup;
    String sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nomeUsuario = (EditText) findViewById(R.id.nome_usuario);
        emailUsuario = (EditText) findViewById(R.id.email_usuario);
        senhaUsuario = (EditText) findViewById(R.id.idade_usuario);

        buttonSalvar = (Button) findViewById(R.id.button_salvar);
        buttonLimpar = (Button) findViewById(R.id.button_limpar);

        buttonSalvar.setOnClickListener(this);
        buttonLimpar.setOnClickListener(this);

        radioGroup = (RadioGroup) findViewById(R.id.opcao_sexo);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.button_limpar:

                nomeUsuario.setText("");
                emailUsuario.setText("");
                senhaUsuario.setText("");
                radioGroup.clearCheck();
                break;

            case R.id.button_salvar:
                int idade;
                String nome = nomeUsuario.getText().toString();
                String textoIdade = senhaUsuario.getText().toString();
                String email = emailUsuario.getText().toString();

                if (nome.equals("")){
                    Toast.makeText(this,"Digite Um Nome",Toast.LENGTH_SHORT).show();
                    break;
                }else{

                    if (email.equals("")){
                        Toast.makeText(this,"Digite Um Email",Toast.LENGTH_SHORT).show();
                        break;
                    }else {

                        if (textoIdade.equals("")){
                            Toast.makeText(this,"Digite Uma Idade",Toast.LENGTH_SHORT).show();
                            break;
                        }else {

                            if (sexo == null){
                                Toast.makeText(this,"Selecione Um Sexo",Toast.LENGTH_SHORT).show();
                                break;
                            }else {

                                idade = Integer.parseInt(textoIdade);
                                Intent intent = new Intent(this,Main2Activity.class);

                                intent.putExtra("pessoa", new Pessoa(nome,email,idade,sexo));

                                startActivity(intent);
                                nomeUsuario.setText("");
                                emailUsuario.setText("");
                                senhaUsuario.setText("");
                                radioGroup.clearCheck();

                                break;
                            }

                        }
                    }

                }




        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId){

            case R.id.sexo_m:
                sexo = "Masculino";
                break;
            case R.id.sexo_f:
                sexo = "Feminino";
                break;

        }
    }
}
