package com.example.imobil.serviços;

import android.telecom.Call;

import com.example.imobil.PerfilUsuario;

import retrofit2.http.GET;

public interface ApiService {
    @GET("user/profile")
    Call<PerfilUsuario> getUserProfile();
}

