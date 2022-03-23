package com.ttiki.planets.room.dao;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ttiki.planets.model.Planet;
import com.ttiki.planets.model.PlanetInfo;

@Database(entities = {Planet.class, PlanetInfo.class}, version = 1)
public abstract class PlanetDataBase extends RoomDatabase {
    public abstract PlanetDao planetDao();

    public abstract PlanetInfoDao planetInfoDao();
}
