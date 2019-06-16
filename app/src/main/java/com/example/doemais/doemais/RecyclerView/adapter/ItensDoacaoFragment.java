package com.example.doemais.doemais.RecyclerView.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doemais.doemais.MainActivity;
import com.example.doemais.doemais.R;
import com.example.doemais.doemais.RecyclerView.modelo.Item;
import com.example.doemais.doemais.WEBService.Service.APIService;
import com.example.doemais.doemais.WEBService.Service.RestClient;
import com.example.doemais.doemais.WEBService.model.ItemModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ItensDoacaoFragment extends Fragment {

    RecyclerView recyclerView;
    APIService apiService;
    ArrayList<Item> itens;
    TextView textView_detCod;
    TextView textView_detInst;
    LinearLayout linearLayout_avaliar;
    Button button_mensagem;

    public ItensDoacaoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_itens_doacao, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_itens);
        textView_detCod = view.findViewById(R.id.detCodigo);
        textView_detInst = view.findViewById(R.id.detInstituicao);
        button_mensagem = view.findViewById(R.id.button_mensagem);
        linearLayout_avaliar = view.findViewById(R.id.linearLayout_avaliar);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        int cod = 0;
        int op = -1;
        String instituicao = "";

        if (getArguments() != null) {
            cod = getArguments().getInt("cod");
            instituicao = getArguments().getString("inst");
            op = getArguments().getInt("op");
        }
        getItens(cod);
        textView_detCod.setText((cod + ""));
        textView_detInst.setText(instituicao);
        if(op == 0){
            button_mensagem.setVisibility(View.VISIBLE);
        }else if(op == 1){
            button_mensagem.setVisibility(View.VISIBLE);
            linearLayout_avaliar.setVisibility(View.VISIBLE);
        }

        final int COD = cod;
        button_mensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                ((MainActivity)e.getContext()).enviarMensagem(0, COD);
            }
        });
    }

    private void getItens(final int cod) {
        itens = new ArrayList<>();
        apiService = RestClient.getSource();

        apiService.getItens(cod).enqueue(new Callback<ArrayList<com.example.doemais.doemais.WEBService.model.ItemModel>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.doemais.doemais.WEBService.model.ItemModel>> call, Response<ArrayList<com.example.doemais.doemais.WEBService.model.ItemModel>> response) {
                ArrayList<ItemModel> itemModels = new ArrayList<>();
                itemModels.addAll(response.body());
                for (ItemModel item : itemModels) {
                    Item item1 = new Item();
                    item1.setNome(item.getNome());
                    item1.setQtd(item.getQtd());
                    itens.add(item1);
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(new ItemQtdDetalhesAdapter(itens, cod));
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.doemais.doemais.WEBService.model.ItemModel>> call, Throwable t) {
                Toast.makeText(ItensDoacaoFragment.this.getContext(), "" + t, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
