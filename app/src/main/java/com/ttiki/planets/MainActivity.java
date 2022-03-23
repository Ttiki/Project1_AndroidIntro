package com.ttiki.planets;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.ttiki.planets.adapters.PlanetsAdapter;
import com.ttiki.planets.databinding.ActivityMainBinding;
import com.ttiki.planets.model.Planet;
import com.ttiki.planets.network.PlanetsApi;
import com.ttiki.planets.room.dao.PlanetDataBase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivityMainBinding.inflate(getLayoutInflater());
        PlanetDataBase db = Room.databaseBuilder(getApplicationContext(),
                PlanetDataBase.class, "planet_db").allowMainThreadQueries().build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://my-json-server.typicode.com/UPPA-s-University-Projects/")
                .build();
        PlanetsApi service = retrofit.create(PlanetsApi.class);
        Call<List<Planet>> planetsCall = service.getPlanets();
        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        ui.planetsRv.setLayoutManager(lm);
        planetsCall.enqueue(new Callback<List<Planet>>() {
            @Override
            public void onResponse(Call<List<Planet>> call, Response<List<Planet>> response) {
                ArrayList<Planet> planets;
                planets = new ArrayList(response.body());
                if (db.planetDao().getAll().size() > 0) {
                    db.planetDao().deleteAll();
                }
                db.planetDao().insertAll(planets);
                PlanetsAdapter planetsAdapter = new PlanetsAdapter(planets);
                planetsAdapter.setOnItemClickListener(postition -> {
                    Log.d("Log", "Planet " + planets.get(postition).getNom() + " clicked");
                    Intent detail = new Intent(getApplicationContext(), PlanetDetailActivity.class);
                    detail.putExtra("id", planets.get(postition).id);
                    startActivity(detail);
                });
                ui.planetsRv.setAdapter(planetsAdapter);
            }

            @Override
            public void onFailure(Call<List<Planet>> call, Throwable t) {
                ArrayList<Planet> planets;
                if (db.planetDao().getAll().size() > 0) {
                    planets = new ArrayList(db.planetDao().getAll());
                    PlanetsAdapter planetsAdapter = new PlanetsAdapter(planets);
                    planetsAdapter.setOnItemClickListener(postition -> {
                        Log.d("Log", "Planet " + planets.get(postition).getNom() + " clicked");
                        Intent detail = new Intent(getApplicationContext(), PlanetDetailActivity.class);
                        detail.putExtra("id", planets.get(postition).id);
                        startActivity(detail);
                    });
                    ui.planetsRv.setAdapter(planetsAdapter);
                } else {
                    Toast.makeText(getApplicationContext(), "Pas de réseau", Toast.LENGTH_LONG).show();
                }

            }
        });


        setContentView(ui.getRoot());
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Log", "OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Log", "OnResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Log", "OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Log", "OnStop");
    }
}