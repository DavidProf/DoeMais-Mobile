package com.example.doemais.doemais.WEBService.Service;

import com.example.doemais.doemais.WEBService.model.Doacao;
import com.example.doemais.doemais.WEBService.model.Doador;
import com.example.doemais.doemais.WEBService.model.ItemModel;
import com.example.doemais.doemais.WEBService.model.Login;
import com.example.doemais.doemais.WEBService.model.Mensagem;
import com.example.doemais.doemais.WEBService.model.Qtd;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    String URL_BASE = "http://192.168.15.4:45455/api/";

    @GET("doador/login")
    Call<Login> doLogin(@Query("email") String email, @Query("senha") String senha);

    @GET("doador/doacao/doadas/qtd")
    Call<Qtd> getQtdDoadas(@Query("email") String email, @Query("senha") String senha);

    @GET("doador/doacao/doadas/itens/qtd")
    Call<Qtd> getQtdDoadasItens(@Query("email") String email, @Query("senha") String senha);

    @GET("doador/doacao/pendentes")
    Call<ArrayList<Doacao>> getPendentes(@Query("email") String email, @Query("senha") String senha);

    @GET("doador/doacao/itens")
    Call<ArrayList<ItemModel>> getItens(@Query("cod") int cod);

    @GET("doador/doacao/doadas")
    Call<ArrayList<Doacao>> getDoacoes(@Query("email") String email, @Query("senha") String senha);

    @GET("Doador")
    Call<Doador> getDoadorDados(@Query("email") String email, @Query("senha") String senha);

    @GET("doador/mensagem/lista")
    Call<ArrayList<Mensagem>> getMensagensLista(@Query("email") String email, @Query("senha") String senha);

    @POST("doador/mensagem")
    Call<Mensagem> EnviarMensagemPorIdDoacao(@Query("iddoacao") int iddoacao, @Query("email") String email, @Query("senha") String senha, @Query("texto") String texto);

    @POST("doador/mensagem")
    Call EnviarMensagemPorIdMensagem(@Query("idmensagem") int idmensagem, @Query("email") String email, @Query("senha") String senha, @Query("texto") String texto);

}
