package com.example.doemais.doemais;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.doemais.doemais.fragments.AvaliarFragment;
import com.example.doemais.doemais.fragments.ItensDoacaoFragment;
import com.example.doemais.doemais.fragments.ConversaFragment;
import com.example.doemais.doemais.fragments.DoacaoFragment;
import com.example.doemais.doemais.fragments.EnviarMensagemFragment;
import com.example.doemais.doemais.fragments.HomeFragment;
import com.example.doemais.doemais.fragments.MensagemFragment;
import com.example.doemais.doemais.fragments.PerfilFragment;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment = new HomeFragment();
    DoacaoFragment doacaoFragment = new DoacaoFragment();
    MensagemFragment mensFragment = new MensagemFragment();
    PerfilFragment perfilFragment = new PerfilFragment();
    ItensDoacaoFragment itensDoacaoFragment = new ItensDoacaoFragment();
    com.example.doemais.doemais.fragments.EnviarMensagemFragment EnviarMensagemFragment = new EnviarMensagemFragment();
    ConversaFragment conversaFragment = new ConversaFragment();
    AvaliarFragment avaliarFragment = new AvaliarFragment();

    Toolbar toolbar;
    TextView toolbarTitulo;
    Button toolbarSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbarTitulo = (TextView) findViewById(R.id.toolbarTitulo);
        toolbarSair = (Button) findViewById(R.id.toolbarSair);
        toolbarSair.setVisibility(View.INVISIBLE);
        toolbarSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("login_preferences", MODE_PRIVATE);
                SharedPreferences.Editor edit = preferences.edit();
                edit.clear();
                edit.commit();

                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });

        //Habilitar toolbar
        Configuration configuration = getResources().getConfiguration();
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbarTitulo.setText("Home");
        setFragment(homeFragment);

        navigationBar();


    }

    //Barra de navegação
    public void navigationBar() {
        BottomNavigationView navigationView = findViewById(R.id.nav_menu);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item_home: {
                        toolbarTitulo.setText("Home");
                        toolbarSair.setVisibility(View.INVISIBLE);
                        homeFragment = new HomeFragment();
                        setFragment(homeFragment);
                        break;
                    }
                    case R.id.item_doacao: {
                        toolbarTitulo.setText("Doações");
                        toolbarSair.setVisibility(View.INVISIBLE);
                        setFragment(doacaoFragment);
                        break;
                    }
                    case R.id.item_mens: {
                        toolbarTitulo.setText("Mensagens");
                        toolbarSair.setVisibility(View.INVISIBLE);
                        setFragment(mensFragment);
                        break;
                    }
                    case R.id.item_perfil: {
                        toolbarTitulo.setText("Perfil");
                        toolbarSair.setVisibility(View.VISIBLE);
                        setFragment(perfilFragment);
                        break;
                    }
                }
                return true;
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //
    public void detalhesDoacao(String code, String instituicao, int opcao) {
        //
        int cod = Integer.parseInt(code);
        //
        Bundle bundle = new Bundle();
        bundle.putInt("cod", cod);
        bundle.putString("inst", instituicao);
        bundle.putInt("op", opcao);
        itensDoacaoFragment.setArguments(bundle);
        //
        toolbarTitulo.setText("Detalhes");
        toolbarSair.setVisibility(View.INVISIBLE);
        setFragment(itensDoacaoFragment);
    }

    //
    public void enviarMensagem(int op, int cod) {
        Bundle bundle = new Bundle();
        bundle.putInt("op", op);
        bundle.putInt("cod", cod);
        EnviarMensagemFragment.setArguments(bundle);
        setFragment(EnviarMensagemFragment);
    }

    //
    public void callFragmentMensagem() {
        toolbarTitulo.setText("Mensagens");
        toolbarSair.setVisibility(View.INVISIBLE);
        setFragment(mensFragment);
    }

    //
    public void callFragmentConversa(String idMensagem) {
        Bundle bundle = new Bundle();
        bundle.putInt("cod", Integer.parseInt(idMensagem));
        conversaFragment.setArguments(bundle);
        setFragment(conversaFragment);
    }
    //
    public void callFragmentAvaliar(int cod){
        Bundle bundle = new Bundle();
        bundle.putInt("cod",cod);
        avaliarFragment.setArguments(bundle);
        setFragment(avaliarFragment);
    }
}
