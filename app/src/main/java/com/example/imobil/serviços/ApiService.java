package com.example.imobil.serviços;

import android.telecom.Call;

import retrofit2.http.GET;

public interface ApiService {
    @GET("user/profile")
    Call getUserProfile();
}

