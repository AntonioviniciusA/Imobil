package com.example.imobil;

public class Anunciados {
    private String tituloAnunciados;
    private String enderecoAnunciados;
    private double valorAnunciados;
    private boolean alugado;
    private boolean vendido;
    private boolean disponivel;

    public Anunciados(String tituloAnunciados, String enderecoAnunciados, double valorAnunciados, boolean alugado, boolean vendido, boolean disponivel) {
        this.tituloAnunciados = tituloAnunciados;
        this.enderecoAnunciados = enderecoAnunciados;
        this.valorAnunciados = valorAnunciados;
        this.alugado = alugado;
        this.vendido = vendido;
        this.disponivel = disponivel;
    }


    private void setDisponivel() {
        if (alugado == true || vendido == true) {
            this.disponivel = false;
        } else {
            this.disponivel = true;
        }
    }

    public String getTituloAnunciados() {
        return tituloAnunciados;
    }

    public void setTituloAnunciados(String tituloAnunciados) {
        this.tituloAnunciados = tituloAnunciados;
    }

    public String getEnderecoAnunciados() {
        return enderecoAnunciados;
    }

    public void setEnderecoAnunciados(String descricaoAnunciados) {
        this.enderecoAnunciados = descricaoAnunciados;
    }

    public double getValorAnunciados() {
        return valorAnunciados;
    }

    public void setValorAnunciados(double valorAnunciados) {
        this.valorAnunciados = valorAnunciados;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
