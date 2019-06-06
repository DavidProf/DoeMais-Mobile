package com.example.doemais.doemais.RecyclerView.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doemais.doemais.R;
import com.example.doemais.doemais.RecyclerView.modelo.Mensagens;

import java.util.ArrayList;

public class MensagemAdapter extends RecyclerView.Adapter<MensagemAdapter.ViewHolderMensagem> {

    Context mContext;
    ArrayList<Mensagens> mensagem;

    public MensagemAdapter(Context mContext, ArrayList<Mensagens> mensagem) {
        this.mContext = mContext;
        this.mensagem = mensagem;
    }

    @NonNull
    @Override
    public MensagemAdapter.ViewHolderMensagem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.lista_mensagem, viewGroup, false);
        ViewHolderMensagem holderMensagem = new ViewHolderMensagem(view);

        return holderMensagem;
    }

    @Override
    public void onBindViewHolder(@NonNull MensagemAdapter.ViewHolderMensagem viewHolder, int position) {

        if (mensagem != null && mensagem.size() > 0) {
            Mensagens mensagens = mensagem.get(position);

            viewHolder.msgInstituicao.setText(mensagens.getMsgInstituicao());
            viewHolder.msgData.setText(mensagens.getDataEnvio());
            viewHolder.msgCodigo.setText(mensagens.getMsgCodigo());
        }
    }

    @Override
    public int getItemCount() {
        return mensagem.size();
    }

    public class ViewHolderMensagem extends RecyclerView.ViewHolder {

        public TextView msgInstituicao;
        public TextView msgData;
        public TextView msgCodigo;

        public ViewHolderMensagem(@NonNull View itemView) {
            super(itemView);
            msgInstituicao = (TextView) itemView.findViewById(R.id.msgIntituicao);
            msgData = (TextView) itemView.findViewById(R.id.msgData);
            msgCodigo = (TextView) itemView.findViewById(R.id.msgCodigo);

        }
    }
}
