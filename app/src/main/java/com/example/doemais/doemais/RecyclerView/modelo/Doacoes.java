package com.example.doemais.doemais.RecyclerView.modelo;

public class Doacoes {

    private String doaInstituicao;
    private String doaData;
    private String doaCodigo;

    public String getDoaInstituicao() {
        return doaInstituicao;
    }

    public void setDoaInstituicao(String doaInstituicao) {
        this.doaInstituicao = doaInstituicao;
    }

    public String getDoaData() {
        return doaData;
    }

    public void setDoaData(String doaData) {
        this.doaData = doaData;
    }

    public String getDoaCodigo() {
        return doaCodigo;
    }

    public void setDoaCodigo(String doaCodigo) {
        this.doaCodigo = doaCodigo;
    }

    public Doacoes(String doaInstituicao, String doaData, String doaCodigo) {
        this.doaInstituicao = doaInstituicao;
        this.doaData = doaData;
        this.doaCodigo = doaCodigo;
    }

}
