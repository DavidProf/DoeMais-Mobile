package com.example.doemais.doemais.WEBService.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemModel {
    @SerializedName("Nome")
    @Expose
    private String nome;
    @SerializedName("Qtd")
    @Expose
    private String qtd;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQtd() {
        return qtd;
    }

    public void setQtd(String qtd) {
        this.qtd = qtd;
    }
}
