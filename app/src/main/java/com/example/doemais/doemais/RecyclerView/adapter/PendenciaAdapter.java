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
import com.example.doemais.doemais.RecyclerView.modelo.Item;
import com.example.doemais.doemais.RecyclerView.modelo.Pendencias;

import java.util.ArrayList;

public class PendenciaAdapter extends RecyclerView.Adapter<PendenciaAdapter.ViewHolderPendencia> {

    Context pContext;
    ArrayList<Pendencias> dados;
    Dialog pDialog;

    public PendenciaAdapter(Context pContext, ArrayList<Pendencias> dados) {
        this.pContext = pContext;
        this.dados = dados;
    }

    @NonNull
    @Override
    public PendenciaAdapter.ViewHolderPendencia onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(pContext).inflate(R.layout.lista_pendencia, viewGroup, false);
        final ViewHolderPendencia holderPendencia = new ViewHolderPendencia(view);

        //Dialog
        pDialog = new Dialog(pContext);
        pDialog.setContentView(R.layout.detalhe_pendencia);

/**/
        final ArrayList<Item> itens = new ArrayList<>();
        /**/
        holderPendencia.listaPend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)v.getContext()).detalhesDoacao();
            }
        });
        return holderPendencia;
    }

    @Override
    public void onBindViewHolder(@NonNull PendenciaAdapter.ViewHolderPendencia holder, int position) {

        if (dados != null && dados.size() > 0) {
            Pendencias pendencias = dados.get(position);

            holder.txtInstituicao.setText(pendencias.getPenInstituicao());
            holder.txtData.setText(pendencias.getPenData());
            holder.txtCodigo.setText(pendencias.getPenCodigo());
        }
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public static class ViewHolderPendencia extends RecyclerView.ViewHolder {

        private RelativeLayout listaPend;
        private TextView txtInstituicao;
        private TextView txtData;
        private TextView txtCodigo;

        public ViewHolderPendencia(@NonNull View itemView) {
            super(itemView);

            listaPend =  itemView.findViewById(R.id.lstPendencia);
            txtInstituicao = itemView.findViewById(R.id.txtInstituicao);
            txtData = itemView.findViewById(R.id.txtDataRegistro);
            txtCodigo = itemView.findViewById(R.id.txtCodigo);
        }
    }
}
