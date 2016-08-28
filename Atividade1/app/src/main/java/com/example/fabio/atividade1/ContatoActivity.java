package com.example.fabio.atividade1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContatoActivity extends AppCompatActivity implements View.OnClickListener{

    Button botaoTel;
    Button botaoEmail;
    Intent intent;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        botaoTel = (Button) findViewById(R.id.botaoTel);
        botaoTel.setOnClickListener(this);
        botaoEmail = (Button) findViewById(R.id.botaoEmail);
        botaoEmail.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.botaoTel:
                uri = Uri.parse("tel:87998111645");
                intent = new Intent(Intent.ACTION_DIAL,uri);
                disparaIntent(intent);
                break;
            case R.id.botaoEmail:
                 intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","fabio.siqueira1222@gmail.com", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Titulo");
                intent.putExtra(Intent.EXTRA_TEXT, "Texto");
                disparaIntent(Intent.createChooser(intent, "Send email..."));
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
