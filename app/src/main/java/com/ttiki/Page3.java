package com.ttiki;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.ttiki.adapters.PlanetsAdapter;
import com.ttiki.model.Planet;
import com.ttiki.network.PlanetsApi;
import com.ttiki.planets.R;
import com.ttiki.planets.databinding.ActivityPage3Binding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Page3 extends AppCompatActivity {
    ActivityPage3Binding ui;
    ArrayList<Planet> planets;

    TextView idLab, tv, planetDist;
    ImageView planetLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivityPage3Binding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());

        Intent i = getIntent();
        int id = i.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);
        System.out.println("Planet id on second page is = " + id);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://my-json-server.typicode.com/UPPA-s-University-Projects/3-2022-Mobile2-cours/")
                .build();
        PlanetsApi service = retrofit.create(PlanetsApi.class);
        Call<List<Planet>> planetsCall = service.getPlanetInfo(id);
        planetsCall.enqueue(new Callback<List<Planet>>() {
            @Override
            public void onResponse(Call<List<Planet>> call, Response<List<Planet>> response) {
                System.out.println("Response called!");
                planets = new ArrayList(response.body());
                Planet planet = planets.get(id);

                idLab = (TextView)findViewById(R.id.planetId);
                tv = (TextView)findViewById(R.id.planetName);
                planetDist = (TextView)findViewById(R.id.planetDistance);
                planetLogo = (ImageView)findViewById(R.id.planet_logo);

                idLab.setText(Integer.toString(id));
                tv.setText(planet.getNom());
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+planet.getNom());
                planetDist.setText(Float.toString(planet.getDistance()));
                Picasso.get().load(planet.getImageUrl()).into(planetLogo);
            }

            @Override
            public void onFailure(Call<List<Planet>> call, Throwable t) {
                System.out.println("ERROR RECEIVED!!!!");
                System.out.println("> Call : " + call);
                System.out.println("> Throwable : " + t);
            }
        });
    }
}