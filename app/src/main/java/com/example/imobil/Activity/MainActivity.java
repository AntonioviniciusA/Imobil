package com.example.imobil.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imobil.Anuncio;
import com.example.imobil.AnuncioAdapter;
import com.example.imobil.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private AnuncioAdapter adapter;
    private List<Anuncio> anuncios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        listView = findViewById(R.id.listView);
        anuncios = new ArrayList<>();
        adapter = new AnuncioAdapter(this, anuncios);
        listView.setAdapter(adapter);

        // Método para carregar dados do banco de dados
        loadAnunciosFromDatabase();

        private void loadAnunciosFromDatabase() {
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
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            // Navegar para a página de pagamentos
            paymentIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, PagamentosActivity.class);
                    startActivity(intent);
                }
            });

            // Navegar para a página de perfil
            profileIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
                    startActivity(intent);
                }
            });


        }
    }
