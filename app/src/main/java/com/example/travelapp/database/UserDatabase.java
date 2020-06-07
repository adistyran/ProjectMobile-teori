package com.example.travelapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.travelapp.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();
}

