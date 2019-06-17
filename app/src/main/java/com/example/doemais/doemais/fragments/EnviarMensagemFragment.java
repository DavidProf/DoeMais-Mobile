package com.example.doemais.doemais.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doemais.doemais.MainActivity;
import com.example.doemais.doemais.R;
import com.example.doemais.doemais.WEBService.Service.APIService;
import com.example.doemais.doemais.WEBService.Service.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class EnviarMensagemFragment extends Fragment {

    APIService apiService;
    //
    EditText editText_mensagem;
    Button button_enviar;

    public EnviarMensagemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_enviar_mensagem, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        button_enviar = getView().findViewById(R.id.button_enviar);
        editText_mensagem = getView().findViewById(R.id.editText_mensagem);

        int op = -1;
        int cod = 0;
        if (getArguments() != null) {
            op = getArguments().getInt("op");
            cod = getArguments().getInt("cod");
        }
        //
        SharedPreferences preferences = this.getActivity().getSharedPreferences("login_preferences", MODE_PRIVATE);
        final String email = preferences.getString("email", "null");
        final String senha = preferences.getString("senha", "null");
        //
        final int OP = op;
        final int COD = cod;
        //
        button_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessagem(OP, COD, email, senha, editText_mensagem.getText().toString());
                ((MainActivity)v.getContext()).callFragmentMensagem();
            }
        });
    }

    public void sendMessagem(int op, int iddoacao, String email, String senha, String texto) {
        apiService = RestClient.getSource();

        if (op == 0) {
            apiService.EnviarMensagemPorIdDoacao(iddoacao, email, senha, texto).enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    Toast.makeText(EnviarMensagemFragment.this.getContext(), "Sucesso", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Toast.makeText(EnviarMensagemFragment.this.getContext(), "Erro", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (op == 1) {

        }
    }

}
