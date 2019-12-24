package com.moustalik.tahar.todoappmvvm;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "taches")
public class Tache  {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "tache")
    private String tache;

    @ColumnInfo(name = "complete")
    private boolean complete = false;


    public Tache(long id, String tache, boolean complete) {
        this.id = id;
        this.tache = tache;
        this.complete = complete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTache() {
        return tache;
    }

    public void setTache(String tache) {
        this.tache = tache;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
