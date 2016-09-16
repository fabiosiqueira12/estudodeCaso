package com.example.fabio.atividade3.listLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.fabio.atividade3.DetalhesFilme;
import com.example.fabio.atividade3.MainActivity;
import com.example.fabio.atividade3.R;
import com.example.fabio.atividade3.model.Filme;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


/**
 * Created by fabio on 10/09/16.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.FilmeViewHolder> implements  ITouchHelperAdapter  {


    //Classe Alinhada
   class FilmeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        //Campos da item_lista.xml
        TextView vNome;
        TextView vCategoria;
        TextView vAno;


        public FilmeViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            vNome = (TextView) itemView.findViewById(R.id.vnome);
            vCategoria = (TextView) itemView.findViewById(R.id.vcategoria);
            vAno = (TextView) itemView.findViewById(R.id.vano);

        }


        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context,DetalhesFilme.class);
            intent.putExtra("filme", listaFilmes.get(getLayoutPosition()));
            context.startActivity(intent);
            Log.d("click","onClick " + listaFilmes.get(getLayoutPosition()));


        }

    }//fimClasseAlinhada


    //campos da classeAdapter
    private Context context;
    private ArrayList<Filme> listaFilmes;
    private View view;


    public MyRecyclerViewAdapter(Context context, ArrayList<Filme> listaFilmes) {
        this.context = context;
        this.listaFilmes = listaFilmes;
    }



    @Override
    public FilmeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.view = LayoutInflater.from(this.context).inflate(R.layout.item_lista,parent,false);
        FilmeViewHolder filmeViewHolder = new FilmeViewHolder(view);
        return  filmeViewHolder;
    }

    @Override
    public void onBindViewHolder(FilmeViewHolder holder, int position) {

        holder.vNome.setText(String.valueOf(this.listaFilmes.get(position).getNome()));
        holder.vCategoria.setText(String.valueOf(this.listaFilmes.get(position).getCategoria()));
        holder.vAno.setText(String.valueOf(this.listaFilmes.get(position).getAnoLancamento()));

    }

    @Override
    public int getItemCount() {
        return (this.listaFilmes != null && this.listaFilmes.size() > 0 ? this.listaFilmes.size() : 0);
    }



    //Método para tratar onMoved com interface mais simples
    @Override
    public boolean onItemMoveu(int posiciaoInicial, int posicicaoFinal) {

        Filme aux = listaFilmes.get(posiciaoInicial);
        listaFilmes.set(posiciaoInicial,listaFilmes.get(posicicaoFinal));
        listaFilmes.set(posicicaoFinal,aux);

        notifyItemMoved(posiciaoInicial, posicicaoFinal);
        return true;

    }


    //Método para excluir Item da lista
    @Override
    public void onItemJogarAoLado(int position){
        listaFilmes.remove(position);
        notifyItemRemoved(position);
    }

}
