package com.example.doemais.doemais.fragments;


import android.animation.ValueAnimator;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.doemais.doemais.RecyclerView.adapter.PendenciaAdapter;
import com.example.doemais.doemais.R;
import com.example.doemais.doemais.RecyclerView.modelo.Pendencias;
import com.example.doemais.doemais.WEBService.Service.APIService;
import com.example.doemais.doemais.WEBService.Service.RestClient;
import com.example.doemais.doemais.WEBService.model.Doacao;
import com.example.doemais.doemais.WEBService.model.Qtd;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private APIService apiService;
    //
    private TextView textView_Donations;
    private TextView textView_Itens;
    //
    private RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar a activity com o fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //
        textView_Donations = view.findViewById(R.id.txtDoacoes);
        textView_Itens = view.findViewById(R.id.txtItens);
        //Instanciar, Definir modelo, e adicionar dados do adapter ao RecyclerView
        recyclerView = view.findViewById(R.id.rvPendente);


        return view;
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
        setQtdDoadas(email, senha);
        setQtdDoadasItens(email, senha);
        setPendencias(email,senha);
    }

    //listar doações com pendência
    private void setPendencias(String email, String senha) {
        apiService = RestClient.getSource();
        apiService.getPendentes(email, senha).enqueue(new Callback<ArrayList<Doacao>>() {
            @Override
            public void onResponse(Call<ArrayList<Doacao>> call, Response<ArrayList<Doacao>> response) {
                ArrayList<Doacao> doacaoList = new ArrayList<>();
                doacaoList.addAll(response.body());
                ArrayList<Pendencias> pendenciasList = new ArrayList<>();
                Pendencias pendencia;
                for (Doacao d : doacaoList) {
                    pendencia = new Pendencias(d.getInstituicao(), d.getDataParaDoar(), d.getCod());
                    pendenciasList.add(pendencia);
                }
                //
                PendenciaAdapter pendenciaAdapter = new PendenciaAdapter(getContext(), pendenciasList);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(pendenciaAdapter);
                recyclerView.addItemDecoration(new DividerItemDecoration(HomeFragment.this.getContext(), DividerItemDecoration.VERTICAL));
            }

            @Override
            public void onFailure(Call<ArrayList<Doacao>> call, Throwable t) {

            }
        });
    }

    //Animaçãozinha dos números
    private void startTimer(final long time, final TextView view, final int qtd) {
        ValueAnimator animator = ValueAnimator.ofInt(0, qtd);
        animator.setDuration(time);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setText(animation.getAnimatedValue() + "");
            }
        });
        animator.start();
    }

    private void setQtdDoadas(String email, String senha) {

        apiService = RestClient.getSource();
        apiService.getQtdDoadas(email, senha).enqueue(new Callback<Qtd>() {
            @Override
            public void onResponse(Call<Qtd> call, Response<Qtd> response) {
                Qtd qtd = response.body();
                startTimer(1800, textView_Donations, qtd.getQuantidade());
            }

            @Override
            public void onFailure(Call<Qtd> call, Throwable t) {

            }
        });
    }

    private void setQtdDoadasItens(String email, String senha) {
        apiService = RestClient.getSource();
        apiService.getQtdDoadasItens(email, senha).enqueue(new Callback<Qtd>() {
            @Override
            public void onResponse(Call<Qtd> call, Response<Qtd> response) {
                Qtd qtd = response.body();
                startTimer(1800, textView_Itens, qtd.getQuantidade());
            }

            @Override
            public void onFailure(Call<Qtd> call, Throwable t) {

            }
        });
    }
}
