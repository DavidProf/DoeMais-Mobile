package com.example.doemais.doemais.WEBService.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Doador {

    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Nome")
    @Expose
    private String nome;
    @SerializedName("Sobrenome")
    @Expose
    private String sobrenome;
    @SerializedName("Sexo")
    @Expose
    private String sexo;
    @SerializedName("Cpf")
    @Expose
    private String cpf;
    @SerializedName("Cep")
    @Expose
    private String cep;
    @SerializedName("Logradouro")
    @Expose
    private String logradouro;
    @SerializedName("Numero")
    @Expose
    private String numero;
    @SerializedName("Complemento")
    @Expose
    private String complemento;
    @SerializedName("Bairro")
    @Expose
    private String bairro;
    @SerializedName("Cidade")
    @Expose
    private String cidade;
    @SerializedName("Uf")
    @Expose
    private String uf;
    @SerializedName("TelefoneA")
    @Expose
    private String telefoneA;
    @SerializedName("TelefoneB")
    @Expose
    private String telefoneB;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefoneA() {
        return telefoneA;
    }

    public void setTelefoneA(String telefoneA) {
        this.telefoneA = telefoneA;
    }

    public String getTelefoneB() {
        return telefoneB;
    }

    public void setTelefoneB(String telefoneB) {
        this.telefoneB = telefoneB;
    }

}