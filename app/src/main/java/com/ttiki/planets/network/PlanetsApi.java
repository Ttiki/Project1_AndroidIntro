package com.ttiki.planets.network;

import com.ttiki.planets.model.Planet;
import com.ttiki.planets.model.PlanetInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlanetsApi {
    @GET("3-2022-Mobile2-cours/planets")
    Call<List<Planet>> getPlanets();

    @GET("3-2022-Mobile2-cours/planets/{idplanet}/infos")
    Call<List<PlanetInfo>> getPlanetInfo(@Path("idplanet") int id);
}
