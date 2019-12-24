package com.moustalik.tahar.todoappmvvm;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TacheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long add(Tache tache);

    @Update
    void update(Tache tache);

    @Delete
    void delete(Tache tache);


    @Query("SELECT * FROM taches")
    List<Tache> getTaches();

}
