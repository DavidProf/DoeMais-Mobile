package com.example.doemais.doemais.RecyclerView.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.doemais.doemais.MainActivity;
import com.example.doemais.doemais.R;
import com.example.doemais.doemais.RecyclerView.modelo.Doacoes;

import java.util.ArrayList;

public class DoacoesAdapter extends RecyclerView.Adapter<DoacoesAdapter.ViewHolderDoacao> {

    Context dContext;
    ArrayList<Doacoes> dadosDoacao;
    Dialog dDialog;


    public DoacoesAdapter(Context dContext, ArrayList<Doacoes> dadosDoacao) {
        this.dadosDoacao = dadosDoacao;
        this.dContext = dContext;
    }

    @NonNull
    @Override
    public DoacoesAdapter.ViewHolderDoacao onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(dContext).inflate(R.layout.lista_doacoes, viewGroup, false);
        final ViewHolderDoacao holderDoacao = new ViewHolderDoacao(view);


        //Dialog
        dDialog = new Dialog(dContext);
        dDialog.setContentView(R.layout.detalhe_doacao);


        holderDoacao.listaDoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cod = holderDoacao.txtCodigo.getText().toString();
                ((MainActivity)v.getContext()).detalhesDoacao(cod);
            }
        });

        return holderDoacao;

    }

    @Override
    public void onBindViewHolder(@NonNull DoacoesAdapter.ViewHolderDoacao holder, int position) {

        if (dadosDoacao != null && dadosDoacao.size() > 0) {
            Doacoes doacoes = dadosDoacao.get(position);

            holder.txtInstituicao.setText(doacoes.getDoaInstituicao());
            holder.txtdataRegistro.setText(doacoes.getDoaData());
            holder.txtCodigo.setText(doacoes.getDoaCodigo());
        }
    }

    @Override
    public int getItemCount() {
        return dadosDoacao.size();
    }


    public class ViewHolderDoacao extends RecyclerView.ViewHolder {

        private TextView txtInstituicao;
        private TextView txtdataRegistro;
        private TextView txtCodigo;
        private RelativeLayout listaDoa;


        public ViewHolderDoacao(@NonNull final View itemView) {
            super(itemView);

            listaDoa = (RelativeLayout) itemView.findViewById(R.id.listaDoa);
            txtInstituicao = (TextView) itemView.findViewById(R.id.txtInstituicao);
            txtdataRegistro = (TextView) itemView.findViewById(R.id.txtDataRegistro);
            txtCodigo = (TextView) itemView.findViewById(R.id.txtCodigo);

        }
    }
}
