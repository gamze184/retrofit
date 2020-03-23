package com.example.retrofit.RestApi;

import com.example.retrofit.Models.Bilgi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/todos")
    Call<List<Bilgi>> getir();
}
