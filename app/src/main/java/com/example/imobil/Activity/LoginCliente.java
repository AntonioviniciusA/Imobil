package com.example.imobil.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.imobil.databinding.ActivityLoginClienteBinding;
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
        final View progressBar = binding.progressBar;
        progressBar.setVisibility(View.VISIBLE);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                navegarTelaPrincipal();
                Snackbar snackbar = Snackbar.make(view, "Login efetuado com sucesso!!", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        }, 3000);
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
