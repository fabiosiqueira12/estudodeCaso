package com.example.fabio.atividade1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AcompanhamentoActivity extends AppCompatActivity {


    TextView faltas;
    TextView saldo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acompanhamento);

        faltas = (TextView) findViewById(R.id.numFaltas);

        String valor = (String) faltas.getText();
        int numFaltas = Integer.parseInt(valor);
        System.out.println(numFaltas);
        saldo = (TextView) findViewById(R.id.numSaldo);
        int saldofinal = 15 - numFaltas;
        saldo.setText(String.valueOf(saldofinal));

    }




}
