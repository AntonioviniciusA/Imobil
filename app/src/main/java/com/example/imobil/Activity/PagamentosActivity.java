package com.example.imobil.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imobil.Debito;
import com.example.imobil.DebitoAdapter;
import com.example.imobil.R;

import java.util.ArrayList;
import java.util.List;


public class PagamentosActivity extends AppCompatActivity {

    private ListView listView;
    private DebitoAdapter debitoAdapter;
    private List<Debito> listaDeDebitos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamentos);

        listView = findViewById(R.id.listViewDebitos);
        listaDeDebitos = new ArrayList<>();

        // Adicionar débitos manualmente para testes
        listaDeDebitos.add(new Debito("Compra no Supermercado", "Supermercado ABC", 250.00));
        listaDeDebitos.add(new Debito("Conta de Luz", "Janeiro 2024", 180.75));
        listaDeDebitos.add(new Debito("Mensalidade Escola", "Escola Infantil XYZ", 500.00));

        debitoAdapter = new DebitoAdapter(this, listaDeDebitos);
        listView.setAdapter(debitoAdapter);

        // Listener de clique nos itens da lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obter o débito clicado
                Debito debitoSelecionado = listaDeDebitos.get(position);

                // Criar Intent para abrir a PagamentoActivity
                Intent intent = new Intent(PagamentosActivity.this, PagamentoActivity.class);

                // Passar os dados do débito para a nova Activity
                intent.putExtra("titulo", debitoSelecionado.getTitulo());
                intent.putExtra("descricao", debitoSelecionado.getDescricao());
                intent.putExtra("valor", debitoSelecionado.getValor());

                // Iniciar a nova Activity
                startActivity(intent);
            }
        });
        // Referência aos ícones do menu
        ImageView homeIcon = findViewById(R.id.home_icon);
        ImageView paymentIcon = findViewById(R.id.payment_icon);
        ImageView profileIcon = findViewById(R.id.profile_icon);

        // Navegar para a mesma página (tela principal)
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagamentosActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Navegar para a página de pagamentos
        paymentIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagamentosActivity.this, PagamentosActivity.class);
                startActivity(intent);
            }
        });

        // Navegar para a página de perfil
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagamentosActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });

    }
}



