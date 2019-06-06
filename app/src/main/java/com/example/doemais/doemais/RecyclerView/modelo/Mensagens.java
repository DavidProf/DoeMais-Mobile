package com.example.doemais.doemais.RecyclerView.modelo;

public class Mensagens  {

    private String nomeFuncionario;
    private String msgInstituicao;
    private String dataEnvio;
    private String msgCodigo;

    public Mensagens(String nomeFuncionario, String instituicao, String dataEnvio, String msgCodigo) {
        this.nomeFuncionario = nomeFuncionario;
        this.msgInstituicao = instituicao;
        this.dataEnvio = dataEnvio;
        this.msgCodigo = msgCodigo;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getMsgInstituicao() {
        return msgInstituicao;
    }

    public void setMsgInstituicao(String msgInstituicao) {
        this.msgInstituicao = msgInstituicao;
    }

    public String getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(String dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getMsgCodigo() {
        return msgCodigo;
    }

    public void setMsgCodigo(String msgCodigo) {
        this.msgCodigo = msgCodigo;
    }

    @Override
    public String toString() {
        return "Mensagens{" +
                "nomeFuncionario='" + nomeFuncionario + '\'' +
                ", msgInstituicao='" + msgInstituicao + '\'' +
                ", dataEnvio='" + dataEnvio + '\'' +
                ", msgCodigo='" + msgCodigo + '\'' +
                '}';
    }
}
