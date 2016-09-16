package com.example.fabio.atividade3.listLayout;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by fabio on 10/09/16.
 */
public class ItemTouchRecycleView extends ItemTouchHelper.Callback {

    //Classe Que trata os eventos de swipper e de move do adapter da RecycleView

    private final ITouchHelperAdapter adapter;//objeto para chamar os métodos onItemMoveu e onItemJogarLado

    public ItemTouchRecycleView(ITouchHelperAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }


    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        adapter.onItemMoveu(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        adapter.onItemJogarAoLado(viewHolder.getAdapterPosition());

    }



}
