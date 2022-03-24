package com.ttiki.mynamemycountry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.ttiki.mynamemycountry.adapters.CountryAdapter;
import com.ttiki.mynamemycountry.model.Country;
import com.ttiki.mynamemycountry.network.IMyNameMyCountryAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextInputEditText et;
    Button btn;
    RecyclerView rv;

    ArrayList<Country> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.nameInput);
        String name = et.getText();

        rv = findViewById(R.id.);

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.nationalize.io/")
                .build();
        IMyNameMyCountryAPI service = retrofit.create(IMyNameMyCountryAPI.class);
        Call<List<Country>> countriesCall = service.getCountryInfo(name);
        countriesCall.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                LinearLayoutManager llm = new LinearLayout(getApplicationContext(), RecyclerView.VERTICAL, false);
                rv.setLayoutManager(llm);
                countries = new ArrayList(response.body());
                CountryAdapter ca = new CountryAdapter(countries);
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {

            }
        });
    }
}