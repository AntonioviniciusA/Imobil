package com.example.imobil.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.imobil.Anuncio;
import com.example.imobil.AnuncioAdapter;
import com.example.imobil.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private AnuncioAdapter adapter;
    private List<Anuncio> anuncios;
    private DrawerLayout drawerLayout;
    private ImageView navOpen;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        //EXEMPLO DE DADOS
        anuncios.add(new Anuncio("Compra no Supermercado", "qs 311", "250.00"));
        anuncios.add(new Anuncio("Mensalidade Escola", "Escola Infantil XYZ", "500.00"));

        listView = findViewById(R.id.listViewAnuncios);
        anuncios = new ArrayList<>();
        adapter = new AnuncioAdapter(this, anuncios);
        listView.setAdapter(adapter);


        // Listener de clique nos itens da lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obter o débito clicado
                Anuncio anuncioSelecionado = anuncios.get(position);

                // Criar Intent para abrir a PagamentoActivity
                Intent intent = new Intent(MainActivity.this, MainActivity.class);

                // Passar os dados do débito para a nova Activity
                intent.putExtra("titulo", anuncioSelecionado.getTituloImo());
                intent.putExtra("descricao", anuncioSelecionado.getEndereco());
                intent.putExtra("valor", anuncioSelecionado.getValor());

                // Iniciar a nova Activity
                startActivity(intent);
            }
        });

            // Referência aos ícones do menu
           drawerLayout = findViewById(R.id.drawer_layout);
           navOpen = findViewById(R.id.nav_open);

           // Defina o clique no ImageView para abrir o Drawer
            navOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abre o DrawerLayout
                drawerLayout.openDrawer(Gravity.LEFT); // Ou Gravity.START
            }
        });

        // Defina o listener para tratar os cliques nos itens do NavigationView
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    // Navegar para a página principal (MainActivity)
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                } else if (id == R.id.nav_Pagamentos) {
                    // Navegar para a página de pagamentos
                    Intent intent = new Intent(MainActivity.this, PagamentosActivity.class);
                    startActivity(intent);
                    return true;
                } else if (id == R.id.nav_Perfil) {
                    // Navegar para a página de perfil
                    Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
                    startActivity(intent);
                    return true;
                }

                // Fechar o drawer após a seleção de um item
                drawerLayout.closeDrawers();

                return false;
            }
        });

        }
}
