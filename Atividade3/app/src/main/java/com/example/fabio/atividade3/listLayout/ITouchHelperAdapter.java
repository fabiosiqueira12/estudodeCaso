package com.example.fabio.atividade3.listLayout;

/**
 * Created by fabio on 10/09/16.
 */
public interface ITouchHelperAdapter {

    boolean onItemMoveu(int fromPosition, int toPosition);

    void onItemJogarAoLado(int position);

}
