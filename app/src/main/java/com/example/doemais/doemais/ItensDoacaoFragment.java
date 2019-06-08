package com.example.doemais.doemais;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doemais.doemais.RecyclerView.adapter.ItemQtdDetalhesAdapter;
import com.example.doemais.doemais.RecyclerView.modelo.Item;

import java.util.ArrayList;


public class ItensDoacaoFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Item> itens;

    public ItensDoacaoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itens = new ArrayList<>();

        Item item = new Item();
        item.setNome("0ii0");
        item.setQtd("05");
        Item item2 = new Item();
        item2.setNome("0ii0");
        item2.setQtd("05");

        itens.add(item);
        itens.add(item2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_itens_doacao, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_itens);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new ItemQtdDetalhesAdapter(itens));

        return view;
    }

}
