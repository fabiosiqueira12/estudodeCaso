package com.example.fabio.atividade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fabio.atividade.model.Aluno;
import com.example.fabio.atividade.model.Pessoa;
import com.example.fabio.atividade.repositorio.RepositorioAluno;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener,RadioGroup.OnCheckedChangeListener {

    //Campos do XML
    private EditText nome;
    private EditText matricula;
    private RadioGroup grupoSexo;
    private AutoCompleteTextView curso;
    private Spinner periodoAtual;
    private CheckBox checkBoxSim;
    private EditText faculdade;
    private Button cadastrar;
    private Button limpar;

    //arrays
    private final String[] cursos = {"analise e desenvolvimento de sistemas","administraçao","engenharia","arquitetura","redes","design"};
    private final String[] periodo = {"1","2","3","4","5","6","7","8"};

    //item selecionado
    String item = null;
    String sexoSelecionado = null;

    //Repositorio Do Aluno
    RepositorioAluno repositorioAluno = RepositorioAluno.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Campos
        this.nome = (EditText) findViewById(R.id.nome);
        this.matricula = (EditText) findViewById(R.id.matricula);
        this.faculdade = (EditText) findViewById(R.id.faculdade);
        this.checkBoxSim = (CheckBox) findViewById(R.id.ch_sim);

        //Botoes
        this.cadastrar = (Button) findViewById(R.id.botao_salvar);
        this.cadastrar.setOnClickListener(this);
        this.limpar = (Button) findViewById(R.id.botao_limpar);
        this.limpar.setOnClickListener(this);


        //Lista Spinner
        this.periodoAtual = (Spinner) findViewById(R.id.spinner_periodo);
        periodoAtual.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, periodo);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        periodoAtual.setAdapter(dataAdapter);


        //AutoCompleteTextView Lista
        this.curso = (AutoCompleteTextView) findViewById(R.id.auto_complete_curso);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,cursos);
        this.curso.setAdapter(adapter);
        this.curso.setThreshold(1);

        //GroupView
        this.grupoSexo = (RadioGroup) findViewById(R.id.radiogroup_sexo);
        this.grupoSexo.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View view) {
         switch (view.getId()){
             case (R.id.botao_salvar):

                 String nomeGet = nome.getText().toString();
                 String matriculaGet = matricula.getText().toString();
                 String sexoGet = this.sexoSelecionado;
                 String cursoGet =  this.curso.getText().toString();
                 String periodoGet = this.item;
                 boolean isNecessidade =  this.checkBoxSim.isChecked();
                 String faculdadeGet = this.faculdade.getText().toString();

                 if (nomeGet.equals("")){
                     Toast.makeText(this,"Digite Um Nome",Toast.LENGTH_LONG).show();
                 }else {

                     if (matriculaGet.equals("")){
                         Toast.makeText(this,"Digite uma matricula",Toast.LENGTH_LONG).show();
                     }else {

                         if (sexoGet == null){
                             Toast.makeText(this,"Selecione Um Sexo",Toast.LENGTH_LONG).show();

                         }else {

                             if (cursoGet.equals("")){
                                 Toast.makeText(this,"Digite Um curso",Toast.LENGTH_LONG).show();

                             }else {

                                 if (periodoGet == null){

                                     Toast.makeText(this,"Selecione Um Periodo",Toast.LENGTH_LONG).show();


                                 }else {

                                     if (faculdadeGet.equals("")){
                                         Toast.makeText(this,"Digite Uma faculade",Toast.LENGTH_LONG).show();

                                     }else {
                                         boolean temCurso = false;
                                         for (int i = 0; i < cursos.length; i++) {
                                             if (cursoGet.equals(cursos[i])){
                                                 temCurso = true;
                                             }
                                         }
                                         if (temCurso) {
                                             Aluno aluno = new Aluno(nomeGet, matriculaGet, sexoGet, cursoGet, periodoGet, isNecessidade, faculdadeGet);
                                             repositorioAluno.adicionarPessoa(aluno);
                                             Toast.makeText(this, "Aluno Adicionado Com Sucesso", Toast.LENGTH_LONG).show();
                                             this.limpaCampos();
                                             System.out.println(aluno);
                                         }else {
                                             Toast.makeText(this, "Esse Curso Nao tem na base de dados", Toast.LENGTH_LONG).show();

                                         }
                                     }

                                 }

                             }

                         }

                     }
                 }

                     break;
             case (R.id.botao_limpar):
                 this.limpaCampos();

                 break;

         }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
         this.item = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i){
                case R.id.radio_sexo_m:
                    sexoSelecionado = "Masculino";
                    break;
                case R.id.rado_sexo_f:
                    sexoSelecionado = "Feminino";
                    break;
            }
    }


    //método para limpar Campos
    private void limpaCampos(){
        this.nome.setText("");
        this.faculdade.setText("");
        this.matricula.setText("");
        this.grupoSexo.clearCheck();
        this.sexoSelecionado = null;
        this.checkBoxSim.setChecked(false);
        this.curso.setText("");
    }

}
