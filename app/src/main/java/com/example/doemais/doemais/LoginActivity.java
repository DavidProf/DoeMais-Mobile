package com.example.doemais.doemais;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doemais.doemais.WEBService.Service.APIService;
import com.example.doemais.doemais.WEBService.Service.RestClient;
import com.example.doemais.doemais.WEBService.model.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    //
    APIService apiService;
    //Views
    Toolbar toolbar;
    TextView toolbarTitulo;
    Button toolbarSair;

    EditText edtEmail;
    EditText edtSenha;
    Button logar;
    TextView recupSenha;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("login_preferences", MODE_PRIVATE);

        if (preferences.contains("login")) {
            pagHome();
            return;
        }
        //views
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        logar = (Button) findViewById(R.id.btnLogar);
        recupSenha = (TextView) findViewById(R.id.recupSenha);

        toolbarTitulo = (TextView) findViewById(R.id.toolbarTitulo);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbarSair = (Button) findViewById(R.id.toolbarSair);
        toolbarSair.setVisibility(View.INVISIBLE);
        //Habilitar toolbar
        Configuration configuration = getResources().getConfiguration();
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        //Verifica a orientação do dispositivo e muda o titulo da toolbar
        if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            toolbarTitulo.setText("");
        } else {
            toolbarTitulo.setText("Login");
        }

        //listeners
        recupSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagRecuperar();
            }
        });
        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validaCampos())
                    logar();
            }
        });
    }

    //Validar campos
    private boolean validaCampos() {

        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();

        if (campoVazio(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.setError("Email invalido");
            edtEmail.requestFocus();
            return false;

        } else if (campoVazio(senha)) {
            edtSenha.setError("Digite uma senha");
            edtSenha.requestFocus();
            return false;

        } else if (senha.length() < 2) {
            edtSenha.setError("Senha deve ter no mínimo 8 caracteres");
            return false;
        }
        //modelo login
        return true;
    }

    private boolean campoVazio(String valor) {
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }

    private void pagHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void pagRecuperar() {
        startActivity(new Intent(this, RecuperarActivity.class));
    }

    private void logar() {
        final String email = edtEmail.getText().toString();
        final String senha = edtSenha.getText().toString();

        apiService = RestClient.getSource();
        apiService.doLogin(email, senha).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                Login lg;
                lg = response.body();
                if (lg.getSucesso()) {
                    //Salvando email e senha
                    SharedPreferences preferences = getSharedPreferences("login_preferences", MODE_PRIVATE);
                    SharedPreferences.Editor edit = preferences.edit();
                    edit.putString("email", email);
                    edit.putString("senha", senha);
                    edit.putBoolean("login", true);
                    edit.commit();

                    pagHome();
                } else {
                    Toast.makeText(LoginActivity.this, "Emal/Senha inválidos!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Falha ao conectar ao banco", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
