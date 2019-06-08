package com.example.doemais.doemais.WEBService.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Doacao {

    @SerializedName("Cod")
    @Expose
    private String cod;
    @SerializedName("Instituicao")
    @Expose
    private String instituicao;
    @SerializedName("DataDoada")
    @Expose
    private String dataDoada;
    @SerializedName("DataParaDoar")
    @Expose
    private String dataParaDoar;
    @SerializedName("DataParaRetirada")
    @Expose
    private String dataParaRetirada;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getDataDoada() {
        return dataDoada;
    }

    public void setDataDoada(String dataDoada) {
        this.dataDoada = dataDoada;
    }

    public String getDataParaDoar() {
        return dataParaDoar;
    }

    public void setDataParaDoar(String dataParaDoar) {
        this.dataParaDoar = dataParaDoar;
    }

    public String getDataParaRetirada() {
        return dataParaRetirada;
    }

    public void setDataParaRetirada(String dataParaRetirada) {
        this.dataParaRetirada = dataParaRetirada;
    }

}