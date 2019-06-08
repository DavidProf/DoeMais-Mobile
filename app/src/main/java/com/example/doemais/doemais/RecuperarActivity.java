package com.example.doemais.doemais;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class RecuperarActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView toolbarTitulo;
    Button toolbarSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbarTitulo = (TextView) findViewById(R.id.toolbarTitulo);
        toolbarSair = (Button) findViewById(R.id.toolbarSair);
        toolbarSair.setVisibility(View.INVISIBLE);

        //Habilitar toolbar
        Configuration configuration = getResources().getConfiguration();
        toolbar.setTitle("");
        setSupportActionBar(toolbar);





    }
}
