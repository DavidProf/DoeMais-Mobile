package com.example.doemais.doemais.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.doemais.doemais.RecyclerView.adapter.DoacoesAdapter;
import com.example.doemais.doemais.R;
import com.example.doemais.doemais.RecyclerView.modelo.Doacoes;
import com.example.doemais.doemais.WEBService.Service.APIService;
import com.example.doemais.doemais.WEBService.Service.RestClient;
import com.example.doemais.doemais.WEBService.model.Doacao;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class DoacaoFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Doacoes> alDoacoes;
    private APIService apiService;

    public DoacaoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar a activity com o fragment
        View view1 = inflater.inflate(R.layout.fragment_doacao, container, false);
        //Instanciar, Definir modelo, e adicionar dados do adapter ao RecyclerView
        recyclerView = (RecyclerView) view1.findViewById(R.id.rvDoacoes);
        return view1;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        //
        SharedPreferences preferences = this.getActivity().getSharedPreferences("login_preferences", MODE_PRIVATE);
        String email = preferences.getString("email", "null");
        String senha = preferences.getString("senha", "null");
        //
        setDoacoesLista(email, senha);
    }

    private void setDoacoesLista(String email, String senha) {
        apiService = RestClient.getSource();
        apiService.getDoacoes(email, senha).enqueue(new Callback<ArrayList<Doacao>>() {
            @Override
            public void onResponse(Call<ArrayList<Doacao>> call, Response<ArrayList<Doacao>> response) {
                ArrayList<Doacao> doacoes = new ArrayList<>();
                doacoes.addAll(response.body());
                alDoacoes = new ArrayList<>();
                for (Doacao doacao : doacoes) {
                    alDoacoes.add(new Doacoes(doacao.getInstituicao(), doacao.getDataDoada(), doacao.getCod()));
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(new DoacoesAdapter(getContext(), alDoacoes));
                recyclerView.addItemDecoration(new DividerItemDecoration(DoacaoFragment.this.getContext(), DividerItemDecoration.VERTICAL));
            }

            @Override
            public void onFailure(Call<ArrayList<Doacao>> call, Throwable t) {
                Toast.makeText(DoacaoFragment.this.getContext(), "Erro: verifique sua conexão", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
