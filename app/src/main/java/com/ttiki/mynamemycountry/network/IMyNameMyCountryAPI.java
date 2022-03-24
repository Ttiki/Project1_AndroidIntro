package com.ttiki.mynamemycountry.network;

import com.ttiki.mynamemycountry.model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IMyNameMyCountryAPI {
    @GET("")
    Call<List<Country>> getCountryInfo(@Query("name") String name);
}
