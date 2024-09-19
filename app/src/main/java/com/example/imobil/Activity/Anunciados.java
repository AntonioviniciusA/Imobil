package com.example.imobil.Activity;

public class Anunciados {
    private String titulo;

    public Anunciados(String titulo, String endereco, String valor) {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setNome(String nome) {
        this.titulo = nome;
    }

    private String endereco;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    private String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    private boolean alugado;

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    private Boolean vendido;

    public Boolean getVendido() {
        return vendido;
    }

    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }

    private boolean disponivel;

    public boolean isDisponivel() {
        return disponivel;
    }

    private void setDisponivel() {
        if (alugado == true || vendido == true) {
            disponivel = false;
        } else {
            disponivel = true;
        }
    }
}
