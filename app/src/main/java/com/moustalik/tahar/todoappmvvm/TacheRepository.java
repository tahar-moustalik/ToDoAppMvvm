package com.moustalik.tahar.todoappmvvm;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TacheRepository {

    private static TacheRepository instance;

    private TacheDao tacheDao;

    public static TacheRepository getInstance(Application application){
        if(instance == null){
            instance = new TacheRepository(application);
        }
        return instance;
    }

    private TacheRepository(Application application) {
        tacheDao = TacheDatabase.getDatabase(application).tacheDao();

    }


    @NonNull
    public List<Tache> loadTaches() {
        return tacheDao.getTaches();
    }

    public long insert(Tache tache) {
        return tacheDao.add(tache);
    }

    public void delete(Tache tache) {
        tacheDao.delete(tache);
    }

    public void update(Tache tache) {
        tacheDao.update(tache);
    }



}
