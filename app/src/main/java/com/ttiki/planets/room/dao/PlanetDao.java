package com.ttiki.planets.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.ttiki.planets.model.Planet;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PlanetDao {
    @Query("SELECT * FROM planet")
    List<Planet> getAll();

    @Insert
    void insertAll(ArrayList<Planet> planets);

    @Query("DELETE FROM planet")
    void deleteAll();
}
