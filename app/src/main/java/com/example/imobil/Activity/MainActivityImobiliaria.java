package com.example.imobil.Activity;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.imobil.Anuncio;
import com.example.imobil.AnuncioAdapter;
import com.example.imobil.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivityImobiliaria {
    private ListView listView;
    private AnunciadosAdapter adapter;
    private List<Anunciados> anunciados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal_imobiliaria);

        listView = findViewById(R.id.listViewAnunciados);
        anunciados = new ArrayList<>();
        adapter = new AnunciadosAdapter(this, anunciados);
        listView.setAdapter(adapter);

        // Método para carregar dados do banco de dados
        loadAnunciados();

        private void loadAnuncios(){
            // Implemente aqui a lógica para buscar os dados do banco de dados
            //Adicionar os dados à lista de anúncios e notificar o adaptador
            Anuncio.add(new Anuncio("Título 1", "Descrição 1", "R$ 100,00"));
            adapter.notifyDataSetChanged();
        }
        // Referência aos ícones do menu
        ImageView homeIcon = findViewById(R.id.home_icon);
        ImageView paymentIcon = findViewById(R.id.payment_icon);
        ImageView profileIcon = findViewById(R.id.profile_icon);

        // Navegar para a mesma página (tela principal)
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityImobiliaria.this, MainActivityImobiliaria.class);
                startActivity(intent);
            }
        });

        // Navegar para a página de pagamentos
        paymentIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityImobiliaria.this, PagamentosActivityImobiliaria.class);
                startActivity(intent);
            }
        });

        // Navegar para a página de perfil
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityImobiliaria.this, PerfilActivityImobiliaria.class);
                startActivity(intent);
            }
        });


    }
}
