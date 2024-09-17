package com.example.imobil;

public class Debito {
        private String titulo;
        private String descricao;
        private double valor;
        // Construtor
        public Debito(String titulo, String descricao, double valor) {
            this.titulo = titulo;
            this.descricao = descricao;
            this.valor = valor;
        }

        // Getters
        public String getTitulo() {
            return titulo;
        }

        public String getDescricao() {
            return descricao;
        }

        public double getValor() {
            return valor;
        }

        // Setters
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }
    }

