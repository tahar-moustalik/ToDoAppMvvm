package com.moustalik.tahar.todoappmvvm;

import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Tache.class}, version = 1, exportSchema = false)
public abstract class TacheDatabase extends RoomDatabase {

    private static TacheDatabase instance = null;

    public  abstract TacheDao tacheDao();

    public static  TacheDatabase getDatabase(Context context) {
        if (instance == null) {
            synchronized (TacheDatabase.class){
                instance = Room
                        .databaseBuilder(context.getApplicationContext(), TacheDatabase.class,"tache_database")
                        .allowMainThreadQueries()
                        .build();
            }



        }
        return instance;
    }






}
