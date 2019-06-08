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

import com.example.doemais.doemais.RecyclerView.adapter.MensagemAdapter;
import com.example.doemais.doemais.R;
import com.example.doemais.doemais.RecyclerView.modelo.Mensagens;
import com.example.doemais.doemais.WEBService.Service.APIService;
import com.example.doemais.doemais.WEBService.Service.RestClient;
import com.example.doemais.doemais.WEBService.model.Mensagem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class MensagemFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Mensagens> alMensagem;
    private APIService apiService;

    public MensagemFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view2 = inflater.inflate(R.layout.fragment_mensagem, container, false);

        //Instanciar, Definir modelo, e adicionar dados do adapter ao RecyclerView
        recyclerView = (RecyclerView) view2.findViewById(R.id.rvMensagem);

        return view2;
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
        setMensagemLista(email, senha);
    }

    private void setMensagemLista(String email, String senha) {

        apiService = RestClient.getSource();
        apiService.getMensagensLista(email, senha).enqueue(new Callback<ArrayList<Mensagem>>() {
            @Override
            public void onResponse(Call<ArrayList<Mensagem>> call, Response<ArrayList<Mensagem>> response) {
                ArrayList<Mensagem> mensagems = new ArrayList<>();
                mensagems.addAll(response.body());
                alMensagem = new ArrayList<>();

                for (Mensagem mensagem : mensagems) {
                    alMensagem.add(new Mensagens(mensagem.getFuncionario(), mensagem.getInstituicao(), mensagem.getData(), mensagem.getCod()));
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(new MensagemAdapter(getContext(), alMensagem));
                recyclerView.addItemDecoration(new DividerItemDecoration(MensagemFragment.this.getContext(), DividerItemDecoration.VERTICAL));
            }

            @Override
            public void onFailure(Call<ArrayList<Mensagem>> call, Throwable t) {

            }
        });
    }
}
