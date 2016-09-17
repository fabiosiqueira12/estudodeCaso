package com.example.fabio.atividade.listadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fabio.atividade.R;
import com.example.fabio.atividade.model.Aluno;

import java.util.ArrayList;

/**
 * Created by fabio on 17/09/16.
 */
public class MyRecyclerViewAdapter  extends RecyclerView.Adapter<MyRecyclerViewAdapter.AlunoViewHolder>{

    //Classe Alinhada
    class AlunoViewHolder extends RecyclerView.ViewHolder{

        private TextView nome;
        private TextView matricula;
        private TextView curso;

        public AlunoViewHolder(View itemView) {
            super(itemView);

            this.nome = (TextView) itemView.findViewById(R.id.text_nome);
            this.matricula = (TextView) itemView.findViewById(R.id.text_matricula);
            this.curso = (TextView) itemView.findViewById(R.id.text_curso);

        }



    }//Fim Classe alinhada

    private Context context;
    private ArrayList<Aluno> listaAlunos;
    private View view;

    public MyRecyclerViewAdapter(Context context, ArrayList<Aluno> listaAlunos) {
        this.context = context;
        this.listaAlunos = listaAlunos;

    }



    @Override
    public AlunoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.view = LayoutInflater.from(this.context).inflate(R.layout.item_lista,parent,false);
        AlunoViewHolder alunoViewHolder = new AlunoViewHolder(this.view);

        return alunoViewHolder;

    }

    @Override
    public void onBindViewHolder(AlunoViewHolder holder, int position) {

        holder.nome.setText(String.valueOf(this.listaAlunos.get(position).getNome()));
        holder.matricula.setText(String.valueOf(this.listaAlunos.get(position).getMatricula()));
        holder.curso.setText(String.valueOf(this.listaAlunos.get(position).getCurso()));

    }

    @Override
    public int getItemCount() {

        return (this.listaAlunos != null && this.listaAlunos.size() > 0 ? this.listaAlunos.size() : 0);

    }


}
