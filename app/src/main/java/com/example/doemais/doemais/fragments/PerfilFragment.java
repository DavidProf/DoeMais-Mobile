package com.example.doemais.doemais.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doemais.doemais.R;
import com.example.doemais.doemais.WEBService.Service.APIService;
import com.example.doemais.doemais.WEBService.Service.RestClient;
import com.example.doemais.doemais.WEBService.model.Doador;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    //
    APIService apiService;
    //
    EditText editText_nome;
    EditText editText_sobrenome;
    EditText editText_sexo;
    EditText editText_cpf;
    EditText editText_cep;
    EditText editText_logradouro;
    EditText editText_numero;
    EditText editText_complemento;
    EditText editText_bairro;
    EditText editText_cidade;
    EditText editText_uf;
    EditText editText_telefone1;
    EditText editText_telefone2;
    EditText editText_email;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        editText_nome = view.findViewById(R.id.nome);
        editText_sobrenome = view.findViewById(R.id.sobrenome);
        editText_sexo = view.findViewById(R.id.sexo);
        editText_cpf = view.findViewById(R.id.cpf);
        editText_cep = view.findViewById(R.id.cep);
        editText_logradouro = view.findViewById(R.id.logradouro);
        editText_numero = view.findViewById(R.id.numero);
        editText_complemento = view.findViewById(R.id.complemento);
        editText_bairro = view.findViewById(R.id.bairro);
        editText_cidade = view.findViewById(R.id.cidade);
        editText_uf = view.findViewById(R.id.uf);
        editText_telefone1 = view.findViewById(R.id.telefone1);
        editText_telefone2 = view.findViewById(R.id.telefone2);
        editText_email = view.findViewById(R.id.email);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //
        SharedPreferences preferences = this.getActivity().getSharedPreferences("login_preferences", MODE_PRIVATE);
        String email = preferences.getString("email", "null");
        String senha = preferences.getString("senha", "null");
        //
        setDados(email, senha);
    }

    private void setDados(String email, String senha) {
        apiService = RestClient.getSource();
        apiService.getDoadorDados(email, senha).enqueue(new Callback<Doador>() {
            @Override
            public void onResponse(Call<Doador> call, Response<Doador> response) {
                Doador doador = response.body();
                editText_nome.setText(doador.getNome());
                editText_sobrenome.setText(doador.getSobrenome());
                editText_cpf.setText(doador.getCpf());
                editText_cep.setText(doador.getCep());
                editText_logradouro.setText(doador.getLogradouro());
                editText_numero.setText(doador.getNumero());
                editText_complemento.setText(doador.getComplemento());
                editText_bairro.setText(doador.getBairro());
                editText_cidade.setText(doador.getCidade());
                editText_uf.setText(doador.getUf());
                editText_telefone1.setText(doador.getTelefoneA());
                editText_telefone2.setText(doador.getTelefoneB());
                editText_email.setText(doador.getEmail());
            }

            @Override
            public void onFailure(Call<Doador> call, Throwable t) {
                Toast.makeText(PerfilFragment.this.getContext(), "Erro: verifique sua conexão", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
