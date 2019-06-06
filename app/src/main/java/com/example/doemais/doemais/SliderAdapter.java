package com.example.doemais.doemais;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    //Lista de Imagens
    public int[] slide_imagens = {
            R.drawable.ic_logo,
            R.drawable.ic_historico,
            R.drawable.ic_star,
            R.drawable.ic_obg,

    };

    //Lista de Titulos
    public String[] slide_titulo = {
            "Ola, Seja Bem Vindo",
            "Veja suas doações",
            "Avalie o Atendimento",
            "Titulo 4",
    };

    //Lista de Descrição
    public String[] slide_descricao = {
            "Tenha o controle de suas doações na palma da mão.",
            "Consulte o historico de suas doações pendentes e ja concluidas.",
            "Avalie o atendimento recebido ao efetuar a doação e ajude a compartilhar a reputação das instituições.",
            "Titulo 4",
    };

    //Lista de Backgrounds
    public int[] slide_background = {
            R.drawable.gradient_background_azul,
            R.drawable.gradient_background_azul,
            R.drawable.gradient_background_azul1,
            R.drawable.gradient_background_azul2,
    };


    @Override
    public int getCount() {
        return slide_titulo.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (LinearLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_layout, container, false);

        LinearLayout layoutView = (LinearLayout) view.findViewById(R.id.slide);
        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_imagem);
        TextView slideTituloView = (TextView) view.findViewById(R.id.slide_titulo);
        TextView slideDescricao = (TextView) view.findViewById(R.id.slide_descricao);

        layoutView.setBackgroundResource(slide_background[position]);
        slideImageView.setImageResource(slide_imagens[position]);
        slideTituloView.setText(slide_titulo[position]);
        slideDescricao.setText(slide_descricao[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
