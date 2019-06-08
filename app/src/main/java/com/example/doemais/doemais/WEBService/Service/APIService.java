package com.example.doemais.doemais.WEBService.Service;

import com.example.doemais.doemais.WEBService.model.Doacao;
import com.example.doemais.doemais.WEBService.model.Login;
import com.example.doemais.doemais.WEBService.model.Qtd;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    String URL_BASE = "http://192.168.15.5:45455/api/";

    @GET("doador/login")
    Call<Login> doLogin(@Query("email") String email, @Query("senha") String senha);

    @GET("doador/doacao/doadas/qtd")
    Call<Qtd> getQtdDoadas(@Query("email") String email, @Query("senha") String senha);

    @GET("doador/doacao/doadas/itens/qtd")
    Call<Qtd> getQtdDoadasItens(@Query("email") String email, @Query("senha") String senha);

    @GET("doador/doacao/pendentes")
    Call<ArrayList<Doacao>> getPendentes(@Query("email") String email, @Query("senha") String senha);
}
