package com.example.imobil.Activity;

import android.os.Bundle;
import android.telecom.Call;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imobil.serviços.ApiService;
import com.example.imobil.PerfilUsuario;
import com.example.imobil.R;
import com.squareup.picasso.Picasso;

import javax.security.auth.callback.Callback;

import retrofit2.Response;


public class PerfilActivity extends AppCompatActivity {

    private ImageView imgProfilePicture;
    private TextView txtName, txtEmail, txtSavedCards, txtInstitutions;
    private Button btnEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        // Inicializar os componentes da UI
        imgProfilePicture = findViewById(R.id.imgProfilePicture);
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtSavedCards = findViewById(R.id.txtSavedCards);
        txtInstitutions = findViewById(R.id.txtInstitutions);
        btnEditProfile = findViewById(R.id.btnEditProfile);

        // Carregar os dados do perfil
        loadPerfilUsuarioe();
    }

    private void loadPerfilUsuario() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<PerfilUsuario> call = apiService.getUserProfile();
        call.equals(new Callback<PerfilUsuario>() {
            @Override
            public void onResponse(Call<PerfilUsuario> call, Response<PerfilUsuario> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Atualizar a UI com os dados do perfil
                    PerfilUsuario userProfile = response.body();

                    txtName.setText("Nome: " + userProfile.getName());
                    txtEmail.setText("Email: " + userProfile.getEmail());
                    txtSavedCards.setText("Cartão: " + userProfile.getSavedCard());

                    // Atualizando a lista de instituições
                    StringBuilder institutionsText = new StringBuilder();
                    for (String institution : userProfile.getInstitutions()) {
                        institutionsText.append(institution).append("\n");
                    }
                    txtInstitutions.setText(institutionsText.toString());

                    // Carregar a imagem de perfil
                    Picasso.get().load(userProfile.getProfilePictureUrl()).into(imgProfilePicture);
                } else {
                    // Tratar erro
                    Toast.makeText(PerfilActivity.this, "Erro ao carregar perfil", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PerfilUsuario> call, Throwable t) {
                // Tratar falha na requisição
                Toast.makeText(PerfilActivity.this, "Falha na conexão", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

