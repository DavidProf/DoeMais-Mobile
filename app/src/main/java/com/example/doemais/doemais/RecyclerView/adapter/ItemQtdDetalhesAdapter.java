package com.example.doemais.doemais.RecyclerView.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doemais.doemais.R;
import com.example.doemais.doemais.RecyclerView.modelo.Item;

import java.util.ArrayList;

public class ItemQtdDetalhesAdapter extends RecyclerView.Adapter<ItemQtdDetalhesAdapter.ViewHolder> {

    ArrayList<Item> itens;
    int codDoacao = 0;

    public ItemQtdDetalhesAdapter(ArrayList<Item> itens, int codDoacao) {
        this.itens = itens;
        this.codDoacao = codDoacao;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detalhe_item_qtd, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Item item = itens.get(i);

        viewHolder.textView_nome.setText(item.getNome());
        viewHolder.textView_qtd.setText(item.getQtd());
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView_nome;
        TextView textView_qtd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_nome = itemView.findViewById(R.id.detItem);
            textView_qtd = itemView.findViewById(R.id.detQtd);
        }
    }
}
