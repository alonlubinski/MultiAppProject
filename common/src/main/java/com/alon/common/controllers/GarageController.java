package com.alon.common.controllers;


import com.alon.common.dao.GarageAPI;
import com.alon.common.models.Garage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GarageController implements Callback<Garage> {

    static final String BASE_URL = "https://pastebin.com/raw/";

    private Callback_Garage callback_garage;

    public void start(Callback_Garage callback_garage) {
        this.callback_garage = callback_garage;
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        GarageAPI garageAPI = retrofit.create(GarageAPI.class);
        Call<Garage> call = garageAPI.loadData();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Garage> call, Response<Garage> response) {
        if (response.isSuccessful()) {
            Garage garage = response.body();
            System.out.println(garage.getName());
            if (callback_garage != null) {
                callback_garage.garage(garage);
            }
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<Garage> call, Throwable t) {
        t.printStackTrace();
    }

    public interface Callback_Garage {
        void garage(Garage garage);
    }
}
