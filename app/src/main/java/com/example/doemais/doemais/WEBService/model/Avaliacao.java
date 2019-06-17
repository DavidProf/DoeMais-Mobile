package com.example.doemais.doemais.WEBService.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Avaliacao {
    @SerializedName("Atendimento")
    @Expose
    private Integer atendimento;
    @SerializedName("Agilidade")
    @Expose
    private Integer agilidade;
    @SerializedName("Confianca")
    @Expose
    private Integer confianca;
    @SerializedName("Transparencia")
    @Expose
    private Integer transparencia;
    @SerializedName("Cuidado")
    @Expose
    private Integer cuidado;

    public Integer getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Integer atendimento) {
        this.atendimento = atendimento;
    }

    public Integer getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(Integer agilidade) {
        this.agilidade = agilidade;
    }

    public Integer getConfianca() {
        return confianca;
    }

    public void setConfianca(Integer confianca) {
        this.confianca = confianca;
    }

    public Integer getTransparencia() {
        return transparencia;
    }

    public void setTransparencia(Integer transparencia) {
        this.transparencia = transparencia;
    }

    public Integer getCuidado() {
        return cuidado;
    }

    public void setCuidado(Integer cuidado) {
        this.cuidado = cuidado;
    }
}
