package com.example.retrofit.RestApi;

import com.example.retrofit.Models.Bilgi;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance=new ManagerAll();
    public static synchronized ManagerAll getInstance(){
        return ourInstance;
    }
    public Call<List<Bilgi>> getirbilgi(){

       Call<List<Bilgi>> call =getRestApiClient().getir() ;
       return call;
    }
}
