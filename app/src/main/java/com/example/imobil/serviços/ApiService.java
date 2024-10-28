package com.example.imobil.servicos;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface ApiService {

    @FormUrlEncoded
    @POST("loginCliente.php")
    Call<ResponseModel> loginCliente(
            @Field("email") String email,
            @Field("senha") String senha
    );

    @FormUrlEncoded
    @POST("loginImobiliaria.php")
    Call<ResponseModel> loginImobiliaria(
            @Field("cnpj") String cnpj,
            @Field("senha") String senha
    );
}

