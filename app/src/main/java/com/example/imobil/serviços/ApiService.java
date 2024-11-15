package com.example.imobil.serviços;

import com.example.imobil.Anuncio;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    // Método para login de clientes
    @FormUrlEncoded
    @POST("loginCliente")
    Call<ResponseModel> loginCliente(
            @Field("email") String email,
            @Field("senha") String senha
    );

    // Método para login de imobiliárias
    @FormUrlEncoded
    @POST("loginImobiliaria")
    Call<ResponseModel> loginImobiliaria(
            @Field("email") String email,
            @Field("senha") String senha
    );

    // Método para obter perfil do usuário
    @FormUrlEncoded
    @POST("getPerfil")
    Call<ResponseModel> getPerfil(
            @Field("user_id") int userId
    );

    // Método para atualizar o pagamento
    @FormUrlEncoded
    @POST("updatePagamento")
    Call<ResponseModel> updatePagamento(
            @Field("user_id") int userId,
            @Field("payment_info") String paymentInfo
    );

    // Método para obter lista de anúncios
    @GET("getAnuncios")
    Call<List<Anuncio>> getAnuncios();
}
