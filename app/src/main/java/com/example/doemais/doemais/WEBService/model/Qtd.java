package com.example.doemais.doemais.WEBService.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Qtd {

    @SerializedName("Quantidade")
    @Expose
    private Integer quantidade;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}