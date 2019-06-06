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

import com.example.doemais.doemais.RecyclerView.adapter.DoacoesAdapter;
import com.example.doemais.doemais.R;
import com.example.doemais.doemais.RecyclerView.modelo.Doacoes;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DoacaoFragment extends Fragment {


    public DoacaoFragment() {
        // Required empty public constructor
    }


    private RecyclerView recyclerView;
    private ArrayList<Doacoes> alDoacoes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar a activity com o fragment
        View view1 = inflater.inflate(R.layout.fragment_doacao, container, false);


        //Instanciar, Definir modelo, e adicionar dados do adapter ao RecyclerView
        recyclerView = (RecyclerView) view1.findViewById(R.id.rvDoacoes) ;
        DoacoesAdapter doacoesAdapter = new DoacoesAdapter(getContext(), alDoacoes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(doacoesAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));


        return view1;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Adicionar informações na lista.. Obs: Sem necessidade caso use um BD
        alDoacoes = new ArrayList<>();

        alDoacoes.add(new Doacoes("AACD","18/08/2000","1"));
        alDoacoes.add(new Doacoes("AACD","18/08/2000","1"));
        alDoacoes.add(new Doacoes("AACD","18/08/2000","1"));
        alDoacoes.add(new Doacoes("AACD","18/08/2000","1"));
        alDoacoes.add(new Doacoes("AACD","18/08/2000","1"));


    }
}
