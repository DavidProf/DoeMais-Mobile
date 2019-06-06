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

import com.example.doemais.doemais.RecyclerView.adapter.PendenciaAdapter;
import com.example.doemais.doemais.R;
import com.example.doemais.doemais.RecyclerView.modelo.Pendencias;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private ArrayList<Pendencias> alPendencias;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar a activity com o fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Instanciar, Definir modelo, e adicionar dados do adapter ao RecyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.rvPendente) ;
        PendenciaAdapter pendenciaAdapter = new PendenciaAdapter(getContext(), alPendencias);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(pendenciaAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));

        return  view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Adicionar informações na lista.. Obs: Sem necessidade caso use um BD
        alPendencias = new ArrayList<>();

        alPendencias.add(new Pendencias("AACD","18/08/2000","1"));
        alPendencias.add(new Pendencias("AACD","18/08/2000","1"));
        alPendencias.add(new Pendencias("AACD","18/08/2000","1"));
        alPendencias.add(new Pendencias("AACD","18/08/2000","1"));
        alPendencias.add(new Pendencias("AACD","18/08/2000","1"));


    }
}
