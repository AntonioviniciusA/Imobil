package com.example.imobil.serviços;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("loginCliente") // URL relativa ao endpoint de login
    Call<ResponseModel> loginCliente(
            @Field("email") String email,
            @Field("senha") String senha
    );
}
