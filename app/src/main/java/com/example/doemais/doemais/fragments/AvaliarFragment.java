package com.example.doemais.doemais.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.doemais.doemais.MainActivity;
import com.example.doemais.doemais.R;
import com.example.doemais.doemais.WEBService.Service.APIService;
import com.example.doemais.doemais.WEBService.Service.RestClient;
import com.example.doemais.doemais.WEBService.model.Avaliacao;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvaliarFragment extends Fragment {

    //
    APIService apiService;
    //Atendimento
    Button button_atendimento1;
    Button button_atendimento2;
    Button button_atendimento3;
    Button button_atendimento4;
    Button button_atendimento5;
    //
    Button button_agilidade1;
    Button button_agilidade2;
    Button button_agilidade3;
    Button button_agilidade4;
    Button button_agilidade5;
    //
    Button button_confianca1;
    Button button_confianca2;
    Button button_confianca3;
    Button button_confianca4;
    Button button_confianca5;
    //
    Button button_transparencia1;
    Button button_transparencia2;
    Button button_transparencia3;
    Button button_transparencia4;
    Button button_transparencia5;
    //
    Button button_cuidado1;
    Button button_cuidado2;
    Button button_cuidado3;
    Button button_cuidado4;
    Button button_cuidado5;
    //
    Button button_avaliar;
    //
    int atendimento = 0, agilidade = 0, confianca = 0, transparencia = 0, cuidado = 0;


    public AvaliarFragment() {
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
        return inflater.inflate(R.layout.fragment_avaliar, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        button_atendimento1 = getView().findViewById(R.id.button_atendimento1);
        button_atendimento2 = getView().findViewById(R.id.button_atendimento2);
        button_atendimento3 = getView().findViewById(R.id.button_atendimento3);
        button_atendimento4 = getView().findViewById(R.id.button_atendimento4);
        button_atendimento5 = getView().findViewById(R.id.button_atendimento5);
        //
        button_agilidade1 = getView().findViewById(R.id.button_agilidade1);
        button_agilidade2 = getView().findViewById(R.id.button_agilidade2);
        button_agilidade3 = getView().findViewById(R.id.button_agilidade3);
        button_agilidade4 = getView().findViewById(R.id.button_agilidade4);
        button_agilidade5 = getView().findViewById(R.id.button_agilidade5);
        //
        button_confianca1 = getView().findViewById(R.id.button_confianca1);
        button_confianca2 = getView().findViewById(R.id.button_confianca2);
        button_confianca3 = getView().findViewById(R.id.button_confianca3);
        button_confianca4 = getView().findViewById(R.id.button_confianca4);
        button_confianca5 = getView().findViewById(R.id.button_confianca5);
        //
        button_transparencia1 = getView().findViewById(R.id.button_transparencia1);
        button_transparencia2 = getView().findViewById(R.id.button_transparencia2);
        button_transparencia3 = getView().findViewById(R.id.button_transparencia3);
        button_transparencia4 = getView().findViewById(R.id.button_transparencia4);
        button_transparencia5 = getView().findViewById(R.id.button_transparencia5);
        //
        button_cuidado1 = getView().findViewById(R.id.button_cuidado1);
        button_cuidado2 = getView().findViewById(R.id.button_cuidado2);
        button_cuidado3 = getView().findViewById(R.id.button_cuidado3);
        button_cuidado4 = getView().findViewById(R.id.button_cuidado4);
        button_cuidado5 = getView().findViewById(R.id.button_cuidado5);
        //
        button_avaliar = getView().findViewById(R.id.button_avaliar);


        int cod = -1;
        if (getArguments() != null) {
            cod = getArguments().getInt("cod");
        }

        setButtons(button_atendimento1, button_atendimento2, button_atendimento3, button_atendimento4, button_atendimento5, 1);
        setButtons(button_agilidade1, button_agilidade2, button_agilidade3, button_agilidade4, button_agilidade5, 2);
        setButtons(button_confianca1, button_confianca2, button_confianca3, button_confianca4, button_confianca5, 3);
        setButtons(button_transparencia1, button_transparencia2, button_transparencia3, button_transparencia4, button_transparencia5, 4);
        setButtons(button_cuidado1, button_cuidado2, button_cuidado3, button_cuidado4, button_cuidado5, 5);
        getAvaliacao(cod);
        final int COD = cod;
        button_avaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (agilidade == 0 || atendimento == 0 || cuidado == 0 || confianca == 0 || transparencia == 0) {
                    Toast.makeText(AvaliarFragment.this.getContext(), "É necessário dar nota em tudo.", Toast.LENGTH_SHORT).show();
                } else {
                    apiService = RestClient.getSource();
                    apiService.enviarAvaliacao(atendimento, agilidade, confianca, transparencia, cuidado, COD).enqueue(new Callback<Avaliacao>() {
                        @Override
                        public void onResponse(Call<Avaliacao> call, Response<Avaliacao> response) {
                            Toast.makeText(AvaliarFragment.this.getContext(), "Sucesso", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Avaliacao> call, Throwable t) {

                        }
                    });
                    ((MainActivity)v.getContext()).navigationBar(1);
                }
            }
        });
    }

    private void setButtons(final Button button1, final Button button2, final Button button3, final Button button4, final Button button5, final int value) {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButtons(button1, button2, button3, button4, button5);
                button1.setBackgroundResource(R.drawable.button_star_filled);
                if (value == 1) {
                    atendimento = 1;
                } else if (value == 2) {
                    agilidade = 1;
                } else if (value == 3) {
                    confianca = 1;
                } else if (value == 4) {
                    transparencia = 1;
                } else if (value == 5) {
                    cuidado = 1;
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButtons(button1, button2, button3, button4, button5);
                button1.setBackgroundResource(R.drawable.button_star_filled);
                button2.setBackgroundResource(R.drawable.button_star_filled);
                if (value == 1) {
                    atendimento = 2;
                } else if (value == 2) {
                    agilidade = 2;
                } else if (value == 3) {
                    confianca = 2;
                } else if (value == 4) {
                    transparencia = 2;
                } else if (value == 5) {
                    cuidado = 2;
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButtons(button1, button2, button3, button4, button5);
                button1.setBackgroundResource(R.drawable.button_star_filled);
                button2.setBackgroundResource(R.drawable.button_star_filled);
                button3.setBackgroundResource(R.drawable.button_star_filled);
                if (value == 1) {
                    atendimento = 3;
                } else if (value == 2) {
                    agilidade = 3;
                } else if (value == 3) {
                    confianca = 3;
                } else if (value == 4) {
                    transparencia = 3;
                } else if (value == 5) {
                    cuidado = 3;
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButtons(button1, button2, button3, button4, button5);
                button1.setBackgroundResource(R.drawable.button_star_filled);
                button2.setBackgroundResource(R.drawable.button_star_filled);
                button3.setBackgroundResource(R.drawable.button_star_filled);
                button4.setBackgroundResource(R.drawable.button_star_filled);
                if (value == 1) {
                    atendimento = 4;
                } else if (value == 2) {
                    agilidade = 4;
                } else if (value == 3) {
                    confianca = 4;
                } else if (value == 4) {
                    transparencia = 4;
                } else if (value == 5) {
                    cuidado = 4;
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButtons(button1, button2, button3, button4, button5);
                button1.setBackgroundResource(R.drawable.button_star_filled);
                button2.setBackgroundResource(R.drawable.button_star_filled);
                button3.setBackgroundResource(R.drawable.button_star_filled);
                button4.setBackgroundResource(R.drawable.button_star_filled);
                button5.setBackgroundResource(R.drawable.button_star_filled);
                if (value == 1) {
                    atendimento = 5;
                } else if (value == 2) {
                    agilidade = 5;
                } else if (value == 3) {
                    confianca = 5;
                } else if (value == 4) {
                    transparencia = 5;
                } else if (value == 5) {
                    cuidado = 5;
                }
            }
        });
    }

    private void resetButtons(final Button button1, final Button button2, final Button button3, final Button button4, final Button button5) {
        button1.setBackgroundResource(R.drawable.button_star_none);
        button2.setBackgroundResource(R.drawable.button_star_none);
        button3.setBackgroundResource(R.drawable.button_star_none);
        button4.setBackgroundResource(R.drawable.button_star_none);
        button5.setBackgroundResource(R.drawable.button_star_none);
    }

    private void getAvaliacao(int iddoacao) {
        apiService = RestClient.getSource();
        apiService.pegarAvaliacao(iddoacao).enqueue(new Callback<Avaliacao>() {
            @Override
            public void onResponse(Call<Avaliacao> call, Response<Avaliacao> response) {
                Avaliacao av = response.body();
                if (av.getAgilidade() == 0 || av.getAtendimento() == 0 || av.getConfianca() == 0 || av.getCuidado() == 0 || av.getTransparencia() == 0) {
                    button_avaliar.setText("Avaliar");
                } else {
                    button_avaliar.setText("Reavaliar");
                    doClick(button_atendimento1, button_atendimento2, button_atendimento3, button_atendimento4, button_atendimento5, av.getAtendimento());
                    doClick(button_agilidade1, button_agilidade2, button_agilidade3, button_agilidade4, button_agilidade5, av.getAgilidade());
                    doClick(button_confianca1, button_confianca2, button_confianca3, button_confianca4, button_confianca5, av.getConfianca());
                    doClick(button_transparencia1, button_transparencia2, button_transparencia3, button_transparencia4, button_transparencia5, av.getTransparencia());
                    doClick(button_cuidado1, button_cuidado2, button_cuidado3, button_cuidado4, button_cuidado5, av.getCuidado());

                }
            }

            @Override
            public void onFailure(Call<Avaliacao> call, Throwable t) {

            }
        });
    }

    private void doClick(final Button button1, final Button button2, final Button button3, final Button button4, final Button button5, int nota) {
        if (nota == 1) {
            button1.performClick();
        } else if (nota == 2) {
            button2.performClick();
        } else if (nota == 3) {
            button3.performClick();
        } else if (nota == 4) {
            button4.performClick();
        } else if (nota == 5) {
            button5.performClick();
        }
    }
}
