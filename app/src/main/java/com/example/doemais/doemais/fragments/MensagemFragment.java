package com.example.doemais.doemais.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doemais.doemais.RecyclerView.adapter.MensagemAdapter;
import com.example.doemais.doemais.R;
import com.example.doemais.doemais.RecyclerView.modelo.Mensagens;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MensagemFragment extends Fragment {


    public MensagemFragment() {
        // Required empty public constructor
    }


    private RecyclerView recyclerView;
    private ArrayList<Mensagens> alMensagem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view2 = inflater.inflate(R.layout.fragment_mensagem, container, false);

        //Instanciar, Definir modelo, e adicionar dados do adapter ao RecyclerView
        recyclerView = (RecyclerView) view2.findViewById(R.id.rvMensagem);
        MensagemAdapter mensagemAdapter = new MensagemAdapter(getContext(), alMensagem);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mensagemAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));

        return  view2;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Adicionar informações na lista.. Obs: Sem necessidade caso use um BD
        alMensagem = new ArrayList<>();

        alMensagem.add(new Mensagens("Funcionário", "Instituição","01/01/19","Código"));
        alMensagem.add(new Mensagens("Funcionário", "Instituição","01/01/19","Código"));
        alMensagem.add(new Mensagens("Funcionário", "Instituição","01/01/19","Código"));
        alMensagem.add(new Mensagens("Funcionário", "Instituição","01/01/19","Código"));
        alMensagem.add(new Mensagens("Funcionário", "Instituição","01/01/19","Código"));
        alMensagem.add(new Mensagens("Funcionário", "Instituição","01/01/19","Código"));
    }
}
