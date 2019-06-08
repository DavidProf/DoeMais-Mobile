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
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.doemais.doemais.fragments.DoacaoFragment;
import com.example.doemais.doemais.fragments.HomeFragment;
import com.example.doemais.doemais.fragments.MensagemFragment;
import com.example.doemais.doemais.fragments.PerfilFragment;

public class MainActivity extends AppCompatActivity {

    final HomeFragment homeFragment = new HomeFragment();
    final DoacaoFragment doacaoFragment = new DoacaoFragment();
    final MensagemFragment mensFragment = new MensagemFragment();
    final PerfilFragment perfilFragment = new PerfilFragment();
    final ItensDoacaoFragment itensDoacaoFragment = new ItensDoacaoFragment();

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
    public void navigationBar(){
        BottomNavigationView navigationView = findViewById(R.id.nav_menu);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item_home: {
                        toolbarTitulo.setText("Home");
                        toolbarSair.setVisibility(View.INVISIBLE);
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
                    case R.id.item_perfil:{
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

    private void setFragment (Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    //
    public void detalhesDoacao(){
        toolbarTitulo.setText("Detalhes");
        toolbarSair.setVisibility(View.INVISIBLE);
        setFragment(itensDoacaoFragment);

    }
}
