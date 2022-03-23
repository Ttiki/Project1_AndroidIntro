package com.ttiki.network;

import com.ttiki.model.Planet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface PlanetsApi {
    @GET("planets/")
    Call<List<Planet>> getPlanets();

    @GET("planets/{idplanet}/info")
    Call<List<Planet>> getPlanetInfo(@Path("idplanet") int id);
}
