package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.retrofit.Models.Bilgi;
import com.example.retrofit.RestApi.ManagerAll;
import com.example.retrofit.adapters.bilgiadapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
List<Bilgi> bilgiList;
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        istek();

    }
    public void tanimla(){

        listView=(ListView) findViewById(R.id.listview);
    }



    public void istek (){
bilgiList=new ArrayList<>();
        Call<List<Bilgi>> listCall= ManagerAll.getInstance().getirbilgi();
        listCall.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                if (response.isSuccessful()) {
                    bilgiList = response.body();
                    bilgiadapter bilgiadapter=new bilgiadapter(bilgiList,getApplicationContext());
                    listView.setAdapter(bilgiadapter);
                }
            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });

    }
}
