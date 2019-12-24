package com.moustalik.tahar.todoappmvvm;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class TacheViewModel extends AndroidViewModel {

    private static TacheViewModel tacheViewModel = null;
    private TacheRepository tacheRepository;

    private MutableLiveData<List<Tache>>  taches = new MutableLiveData<>();

    public TacheViewModel(@NonNull Application application) {
        super(application);
        this.tacheRepository = TacheRepository.getInstance(application);
        this.taches.setValue(this.tacheRepository.loadTaches());

    }

    public static  TacheViewModel getInstance(Application application) {

        if(tacheViewModel == null) {
            tacheViewModel = new TacheViewModel(application);
        }
        return tacheViewModel;
    }

    public void insert(Tache tache) {
        long id = tacheRepository.insert(tache);
        this.taches.setValue(this.tacheRepository.loadTaches());
        Log.i("TACHE" ,"tache" + id);
    }

    public void delete(Tache tache) {
        tacheRepository.delete(tache);
    }

    public void update(Tache tache) {
        tacheRepository.update(tache);
    }
    public LiveData<List<Tache>> getTaches() {
        return this.taches;
    }



}
