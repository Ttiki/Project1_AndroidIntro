package com.ttiki.activity3_geoloc.network;


import com.ttiki.activity3_geoloc.model.GeoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ILocationAPI {

    @GET("reverse")
    Call<GeoResponse> getAdresse(@Query("lon") double longitude, @Query("lat") double latitude);
}
