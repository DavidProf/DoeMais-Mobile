package com.example.doemais.doemais.WEBService.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mensagem {

    @SerializedName("Instituicao")
    @Expose
    private String instituicao;
    @SerializedName("Funcionario")
    @Expose
    private String funcionario;
    @SerializedName("Doador")
    @Expose
    private String doador;
    @SerializedName("Data")
    @Expose
    private String data;
    @SerializedName("Texto")
    @Expose
    private String texto;
    @SerializedName("Lida")
    @Expose
    private Boolean lida;
    @SerializedName("Cod")
    @Expose
    private String cod;

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getDoador() {
        return doador;
    }

    public void setDoador(String doador) {
        this.doador = doador;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getLida() {
        return lida;
    }

    public void setLida(Boolean lida) {
        this.lida = lida;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

}
