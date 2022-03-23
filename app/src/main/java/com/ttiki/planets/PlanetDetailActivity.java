package com.ttiki.planets;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.ttiki.planets.databinding.ActivityPlanetDetailBinding;
import com.ttiki.planets.model.PlanetInfo;
import com.ttiki.planets.network.PlanetsApi;
import com.ttiki.planets.room.dao.PlanetDataBase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlanetDetailActivity extends AppCompatActivity {
    ActivityPlanetDetailBinding ui;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivityPlanetDetailBinding.inflate(getLayoutInflater());
        int id = getIntent().getIntExtra("id", -1);
        Log.d("HamzaLog", "Id Planet : " + id);
        PlanetDataBase db = Room.databaseBuilder(getApplicationContext(),
                PlanetDataBase.class, "planet_db").allowMainThreadQueries().build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://my-json-server.typicode.com/UPPA-s-University-Projects/")
                .build();
        PlanetsApi service = retrofit.create(PlanetsApi.class);
        Call<List<PlanetInfo>> planetsCall = service.getPlanetInfo(id);
        planetsCall.enqueue(new Callback<List<PlanetInfo>>() {
            @Override
            public void onResponse(Call<List<PlanetInfo>> call, Response<List<PlanetInfo>> response) {
                PlanetInfo pl = response.body().get(0);
                if (db.planetInfoDao().getPlanetInfoByid(id) != null) {
                    db.planetInfoDao().deleteOneByIdPlanet(id);
                }
                db.planetInfoDao().insertAll(pl);
                ui.nom.setText(pl.getName());
                Glide.with(ui.getRoot()).load(pl.getLogo()).into(ui.logo);
                ui.description.setText(pl.getDescription());
                ui.gotoUrl.setText("Plus sur " + pl.getName());
                ui.distSun.setText(Float.toString(pl.getDistance()));
                ui.planteNb.setText(Integer.toString(pl.getPlanetId()));
                ui.gotoUrl.setOnClickListener(v -> {
                    String url = pl.getSeemore();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                });
            }

            @Override
            public void onFailure(Call<List<PlanetInfo>> call, Throwable t) {
                if (db.planetInfoDao().getPlanetInfoByid(id) != null) {
                    PlanetInfo pl = db.planetInfoDao().getPlanetInfoByid(id);
                    ui.nom.setText(pl.getName());
                    Glide.with(ui.getRoot()).load(pl.getLogo()).into(ui.logo);
                    ui.description.setText(pl.getDescription());
                    ui.gotoUrl.setText("Plus sur " + pl.getName());
                    ui.distSun.setText(Float.toString(pl.getDistance()));
                    ui.planteNb.setText(Integer.toString(pl.getPlanetId()));
                    ui.gotoUrl.setOnClickListener(v -> {
                        String url = pl.getSeemore();
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "pas de réseau", Toast.LENGTH_LONG).show();
                }


            }
        });
        setContentView(ui.getRoot());
    }
}