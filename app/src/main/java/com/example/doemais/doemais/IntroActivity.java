package com.example.doemais.doemais;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private Button mBtnAnt;
    private Button mBtnProx;
    private Button mBtnComecar;
    private int mPagAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dots_layout);
        mBtnAnt = (Button) findViewById(R.id.btnAnt);
        mBtnProx = (Button) findViewById(R.id.btnProx);
        mBtnComecar = (Button) findViewById(R.id.btnComecar);

        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);



        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);


        //Mudar slide atraves dos botões
        mBtnProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mPagAtual + 1);

            }
        });

        mBtnAnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSlideViewPager.setCurrentItem(mPagAtual - 1);
            }
        });


        mBtnComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagLogin();

            }
        });

        salvarPreferencias();

    }

    //Mudar dots junto com slide
    public void addDotsIndicator(int position) {
        mDots = new TextView[4];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(45);
            mDots[i].setTextColor(getResources().getColor(R.color.colorWhite));

            mDotLayout.addView(mDots[i]);

        }

        if (mDots.length > 0) {

            mDots[position].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);
            mPagAtual = i;

            if (i == 0) {
                mBtnProx.setEnabled(true);
                mBtnAnt.setEnabled(false);
                mBtnComecar.setEnabled(false);

                mBtnAnt.setVisibility(View.INVISIBLE);
                mBtnComecar.setVisibility(View.INVISIBLE);

                mBtnProx.setText("Proximo");
                mBtnAnt.setText("");
                mBtnComecar.setText("");

            } else if (i == mDots.length - 1) {
                mBtnProx.setEnabled(false);
                mBtnAnt.setEnabled(true);
                mBtnComecar.setEnabled(true);

                mBtnProx.setVisibility(View.INVISIBLE);
                mBtnAnt.setVisibility(View.VISIBLE);
                mBtnComecar.setVisibility(View.VISIBLE);

                mBtnProx.setText("");
                mBtnAnt.setText("Anterior");
                mBtnComecar.setText("Começar");

            } else {
                mBtnProx.setEnabled(true);
                mBtnAnt.setEnabled(true);
                mBtnComecar.setEnabled(false);

                mBtnAnt.setVisibility(View.VISIBLE);
                mBtnComecar.setVisibility(View.INVISIBLE);
                mBtnProx.setVisibility(View.VISIBLE);

                mBtnProx.setText("Proximo");
                mBtnAnt.setText("Anterior");
                mBtnComecar.setText("");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    private void pagLogin() {

        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }




    //Salvar primeira entrada no app
    public void salvarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);


        if (preferences.contains("iniciado")) {
            pagLogin();
        } else {
            appIniciado(preferences);
           // mostrarIntro();
        }
    }


    //Usar com splash screen
   /* private void mostrarIntro() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pagLogin();
            }
        }, 2000);

    }*/

    private void appIniciado(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("iniciado", true);
        editor.commit();
    }
}
