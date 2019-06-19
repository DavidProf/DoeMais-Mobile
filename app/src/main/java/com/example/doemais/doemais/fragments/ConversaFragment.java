package com.example.doemais.doemais.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doemais.doemais.R;
import com.example.doemais.doemais.WEBService.Service.APIService;
import com.example.doemais.doemais.WEBService.Service.RestClient;
import com.example.doemais.doemais.WEBService.model.Mensagem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class ConversaFragment extends Fragment {

    EditText editText_Conversa;
    TextView textView_Conversa;
    Button button_enviar;
    APIService apiService;

    public ConversaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conversa, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        //
        editText_Conversa = getView().findViewById(R.id.editText_mensagem);
        textView_Conversa = getView().findViewById(R.id.textView_conversa);
        button_enviar = getView().findViewById(R.id.button_enviar);
        //
        SharedPreferences preferences = this.getActivity().getSharedPreferences("login_preferences", MODE_PRIVATE);
        final String email = preferences.getString("email", "null");
        final String senha = preferences.getString("senha", "null");
        //
        int cod = -1;
        if (getArguments() != null) {
            cod = getArguments().getInt("cod");
        }
        final int COD = cod;

        pegarMensagens(COD, email, senha);

        button_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarMensagem(COD, email, senha, editText_Conversa.getText().toString());
                editText_Conversa.setText("");
            }
        });
    }

    private void enviarMensagem(final int cod, final String email, final String senha, String texto) {

        apiService = RestClient.getSource();
        apiService.EnviarMensagemPorIdMensagem(cod, email, senha, texto).enqueue(new Callback<Mensagem>() {
            @Override
            public void onResponse(Call<Mensagem> call, Response<Mensagem> response) {
                Toast.makeText(ConversaFragment.this.getContext(), "Enviada", Toast.LENGTH_SHORT).show();

                pegarMensagens(cod, email, senha);
            }

            @Override
            public void onFailure(Call<Mensagem> call, Throwable t) {
                Toast.makeText(ConversaFragment.this.getContext(), "Falha", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void pegarMensagens(int cod, String email, String senha) {
        apiService = RestClient.getSource();

        textView_Conversa.setText("");

        apiService.pegarConversa(cod, email, senha).enqueue(new Callback<ArrayList<Mensagem>>() {
            @Override
            public void onResponse(Call<ArrayList<Mensagem>> call, Response<ArrayList<Mensagem>> response) {
                ArrayList<Mensagem> mensagems = new ArrayList<>();
                mensagems.addAll(response.body());
                for (Mensagem m : mensagems) {
                    String mensagem =
                            (m.getFuncionario().trim().equals("") ? "Você" : m.getFuncionario()) + " " +
                                    "(" + m.getData() + "):\n" +
                                    m.getTexto() + "\n" + (m.getLida() ? "<--->" : "") + "\n" +
                                    "________________";
                    textView_Conversa.setText(textView_Conversa.getText() + "\n" + mensagem);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Mensagem>> call, Throwable t) {

            }
        });

    }
}
