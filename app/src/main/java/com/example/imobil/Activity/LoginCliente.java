package com.example.imobil.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.imobil.databinding.ActivityLoginClienteBinding;
import com.example.imobil.serviços.ApiClient;
import com.example.imobil.serviços.ResponseModel;
import com.google.android.material.snackbar.Snackbar;

public class LoginCliente extends AppCompatActivity {

    private ActivityLoginClienteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializando o binding com o layout correto
        binding = ActivityLoginClienteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));

        binding.btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.editEmail.getText().toString();
                String senha = binding.editSenha.getText().toString();

                if (email.isEmpty()) {
                    binding.editEmail.setError("Preencha o Email!");
                } else if (senha.isEmpty()) {
                    binding.editSenha.setError("Preencha a Senha!");
                } else if (!email.contains("@gmail.com")) {
                    Snackbar snackbar = Snackbar.make(v, "Email inválido!", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                } else if (senha.length() <= 7) {
                    Snackbar snackbar = Snackbar.make(v, "Senha deve ter pelo menos 7 caracteres!", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                } else {
                    login(v);
                }
            }
        });

        binding.txtSouImobiliaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginImobiliariaTela(v);
                Snackbar.make(v, "TextView clicado!", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void login(View view) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ResponseModel> call = apiService.loginCliente(
                binding.editEmail.getText().toString(),
                binding.editSenha.getText().toString()
        );

        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().getStatus().equals("success")) {
                        navegarTelaPrincipal();
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


    private void navegarTelaPrincipal() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void loginImobiliariaTela(View view){
        final View progressBar = binding.progressBar;
        progressBar.setVisibility(View.VISIBLE);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                navegarLoginImobiliaria();
            }
        }, 3000);
    }
    private void navegarLoginImobiliaria() {
        Intent intent = new Intent(this, LoginImobiliaria.class);
        startActivity(intent);
        finish();
    }
}
