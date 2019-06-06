package com.example.doemais.doemais.RecyclerView.modelo;

public class Pendencias {

    private String penInstituicao;
    private String penData;
    private String penCodigo;

    public Pendencias(String penInstituicao, String penData, String penCodigo) {
        this.penInstituicao = penInstituicao;
        this.penData = penData;
        this.penCodigo = penCodigo;
    }

    public String getPenInstituicao() {
        return penInstituicao;
    }

    public void setPenInstituicao(String penInstituicao) {
        this.penInstituicao = penInstituicao;
    }

    public String getPenData() {
        return penData;
    }

    public void setPenData(String penData) {
        this.penData = penData;
    }

    public String getPenCodigo() {
        return penCodigo;
    }

    public void setPenCodigo(String penCodigo) {
        this.penCodigo = penCodigo;
    }

    @Override
    public String toString() {
        return "Pendencias{" +
                "penInstituicao='" + penInstituicao + '\'' +
                ", penData='" + penData + '\'' +
                ", penCodigo='" + penCodigo + '\'' +
                '}';
    }
}
