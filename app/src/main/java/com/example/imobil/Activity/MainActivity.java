package com.example.imobil.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.imobil.Anuncio;
import com.example.imobil.AnuncioAdapter;
import com.example.imobil.R;
import com.example.imobil.serviços.ApiClient;
import com.example.imobil.serviços.ApiService;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private AnuncioAdapter adapter;
    private List<Anuncio> anuncios;
    private DrawerLayout drawerLayout;
    private ImageView navOpen;
    private NavigationView navigationView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        anuncios = new ArrayList<>(); // Inicializar a lista de anúncios

        // Configurando a lista de anúncios
        listView = findViewById(R.id.listViewAnuncios);
        adapter = new AnuncioAdapter(this, anuncios);
        listView.setAdapter(adapter);

        // Configurando o Drawer e o NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
        navOpen = findViewById(R.id.nav_open);
        navigationView = findViewById(R.id.navigation_view); // Inicializando o NavigationView

        // Clique para abrir o Drawer
        navOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        // Listener do NavigationView
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Intent intent;

                if (id == R.id.nav_home) {
                    intent = new Intent(MainActivity.this, MainActivity.class);
                } else if (id == R.id.nav_Pagamentos) {
                    intent = new Intent(MainActivity.this, PagamentosActivity.class);
                } else if (id == R.id.nav_Perfil) {
                    intent = new Intent(MainActivity.this, PerfilActivity.class);
                } else {
                    drawerLayout.closeDrawers();
                    return false;
                }

                startActivity(intent);
                drawerLayout.closeDrawers();
                return true;
            }
        });

        // Clique nos itens da lista de anúncios
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Anuncio anuncioSelecionado = anuncios.get(position);
                Intent intent = new Intent(MainActivity.this, PagamentoActivity.class);

                intent.putExtra("titulo", anuncioSelecionado.getTituloImo());
                intent.putExtra("descricao", anuncioSelecionado.getEndereco());
                intent.putExtra("valor", anuncioSelecionado.getValor());

                startActivity(intent);
            }
        });

        // Chamar o método para carregar os anúncios do banco de dados
        carregarAnuncios();
    }

    // Método para carregar anúncios do banco de dados usando Retrofit
    private void carregarAnuncios() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Anuncio>> call = apiService.getAnuncios();

        call.enqueue(new Callback<List<Anuncio>>() {
            @Override
            public void onResponse(Call<List<Anuncio>> call, Response<List<Anuncio>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    anuncios.clear();
                    anuncios.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    View rootView = findViewById(android.R.id.content);
                    Snackbar.make(rootView, "Erro ao carregar anúncios", Snackbar.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Anuncio>> call, Throwable t) {
                View rootView = findViewById(android.R.id.content);
                Snackbar.make(rootView, "Erro de conexão", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
