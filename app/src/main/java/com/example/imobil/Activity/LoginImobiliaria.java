package com.example.imobil.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imobil.databinding.ActivityLoginImobiliariaBinding;
import com.example.imobil.serviços.ApiClient;
import com.example.imobil.serviços.ApiService;
import com.example.imobil.serviços.ResponseModel;
import com.google.android.material.snackbar.Snackbar;

public class LoginImobiliaria extends AppCompatActivity {
    private ActivityLoginImobiliariaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inicializando o binding com o layout correto
        binding = ActivityLoginImobiliariaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));

        binding.btnEntrarImobiliaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CNPJ = binding.editCnpj.getText().toString();
                String senha = binding.editSenhaimob.getText().toString();

                if (CNPJ.isEmpty()) {
                    binding.editCnpj.setError("Preencha o CNPJ!");
                } else if (senha.isEmpty()) {
                    binding.editSenhaimob.setError("Preencha a Senha!");
                } else if (CNPJ.length() < 15) {
                    Snackbar snackbar = Snackbar.make(v, "CNPJ inválido!", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                } else if (senha.length() <= 7) {
                    Snackbar snackbar = Snackbar.make(v, "Senha deve ter pelo menos 7 caracteres!", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                } else {
                    loginImobiliaria(v); // Corrigido para chamar o método correto
                }
            }
        });


        binding.txtSouinquilino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginClienteTela(v);
                Snackbar.make(v, "TextView clicado!", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void loginImobiliaria(View view) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ResponseModel> call = apiService.loginImobiliaria(
                binding.editCnpj.getText().toString(),
                binding.editSenhaimob.getText().toString()
        );

        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().getStatus().equals("success")) {
                        navegarTelaPrincipalImobiliaria();
                    } else {
                        Snackbar.make(view, response.body().getMessage(), Snackbar.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Snackbar.make(view, "Erro na conexão", Snackbar.LENGTH_SHORT).show();
            }
        });
    }



    private void navegarTelaPrincipalImobiliaria() {
        Intent intent = new Intent(this, MainActivityImobiliaria.class);
        startActivity(intent);
        finish();
    }

    private void loginClienteTela(View view){
        final View progressBar = binding.progressBar;
        progressBar.setVisibility(View.VISIBLE);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                navegarLoginCliente();
            }
        }, 3000);
    }
    private void navegarLoginCliente() {
        Intent intent = new Intent(this, LoginCliente.class);
        startActivity(intent);
        finish();
    }
}
