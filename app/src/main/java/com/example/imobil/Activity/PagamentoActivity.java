package com.example.imobil.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imobil.R;

public class PagamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        // Receber os dados do débito via Intent
        Intent intent = getIntent();
        String titulo = intent.getStringExtra("titulo");
        String descricao = intent.getStringExtra("descricao");
        double valor = intent.getDoubleExtra("valor", 0.0);

        // Vincular os TextViews ao layout e preencher com os dados
        TextView tituloDebito = findViewById(R.id.tituloDebito);
        TextView descricaoDebito = findViewById(R.id.descricaoDebito);
        TextView valorDebito = findViewById(R.id.valorDebito);

        tituloDebito.setText(titulo);
        descricaoDebito.setText(descricao);
        valorDebito.setText(String.format("R$ %.2f", valor));

        // Botões de pagamento
        Button btnCartaoCredito = findViewById(R.id.btnCartaoCredito);
        Button btnTransferencia = findViewById(R.id.btnTransferencia);
        Button btnPix = findViewById(R.id.btnPix);
        Button btnBoleto = findViewById(R.id.btnBoleto);

        // Ação para cada método de pagamento
        btnCartaoCredito.setOnClickListener(v -> {
            // Implementar ação para pagamento com Cartão de Crédito
            Toast.makeText(this, "Pagar com Cartão de Crédito", Toast.LENGTH_SHORT).show();
        });

        btnTransferencia.setOnClickListener(v -> {
            // Implementar ação para pagamento por Transferência Bancária
            Toast.makeText(this, "Pagar com Transferência Bancária", Toast.LENGTH_SHORT).show();
        });

        btnPix.setOnClickListener(v -> {
            // Implementar ação para pagamento com Pix
            Toast.makeText(this, "Pagar com Pix", Toast.LENGTH_SHORT).show();
        });

        btnBoleto.setOnClickListener(v -> {
            // Implementar ação para pagamento com Boleto Bancário
            Toast.makeText(this, "Pagar com Boleto Bancário", Toast.LENGTH_SHORT).show();
        });


    }
}


