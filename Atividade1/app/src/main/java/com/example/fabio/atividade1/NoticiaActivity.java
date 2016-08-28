package com.example.fabio.atividade1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NoticiaActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonLerMais;
    Button buttonCompartilhar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);

        buttonLerMais = (Button) findViewById(R.id.botaoMostraMais);
        buttonLerMais.setOnClickListener(this);
        buttonCompartilhar = (Button) findViewById(R.id.botaoCompartilha);
        buttonCompartilhar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.botaoMostraMais:
                Toast.makeText(this,"Funcionou",Toast.LENGTH_SHORT).show();
                break;
            case R.id.botaoCompartilha:

                intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_SUBJECT, this.getString(R.string.titleGrid));
                intent.putExtra(Intent.EXTRA_TEXT, this.getString(R.string.texto));
                intent.setType("text/plain");
                disparaIntent(intent);
                break;
        }
    }

    //Dispara As Activitys de fora
    private void disparaIntent(Intent intent){

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);

        }else{
            Toast.makeText(this,"ERRO",Toast.LENGTH_SHORT).show();
        }
    }

}
