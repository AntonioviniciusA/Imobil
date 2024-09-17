package com.example.imobil;

public class Anuncio {
    private String tituloImo;

    public Anuncio(String tituloImo, String endereco, String valor) {
    }

    public String getTituloImo() {
        return tituloImo;
    }

    public void setNomeImo(String nomeImo) {
        this.tituloImo = nomeImo;
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
