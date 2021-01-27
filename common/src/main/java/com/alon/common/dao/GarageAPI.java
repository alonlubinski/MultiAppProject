package com.alon.common.dao;

import com.alon.common.models.Garage;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GarageAPI {

    @GET("WypPzJCt")
    Call<Garage> loadData();
}
