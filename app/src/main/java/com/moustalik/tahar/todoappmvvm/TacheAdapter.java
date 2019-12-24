package com.moustalik.tahar.todoappmvvm;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;


public class TacheAdapter extends RecyclerView.Adapter<TacheAdapter.ViewHolder> {
    private  List<Tache> taches;
    private final Context mContext;
    View.OnClickListener listener;

    public TacheAdapter(Context mContext, List<Tache> taches) {
        this.taches = taches;
        this.mContext = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public MaterialTextView mTacheTextView;
        public Button delBtn;

        public ViewHolder(View v) {
            super(v);
            mTacheTextView = v.findViewById(R.id.tv_tache);
            delBtn = v.findViewById(R.id.btn_del_tache);

        }
    }
    @NonNull
    @Override
    // Create new views (Invoked by the Layout Manager)
    public TacheAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tache_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    // Replace the contents of a view (Invoked by the layout manager)
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

          final Tache tache = this.taches.get(position);
           Log.i("TACHEVH", taches.get(position).getTache());
            holder.mTacheTextView.setText(tache.getTache());
    }

    @Override
    public int getItemCount() {

        return taches.size();
    }



    public void setTaches(List<Tache> taches) {
        this.taches.clear();
        this.taches = taches;
    }
}

