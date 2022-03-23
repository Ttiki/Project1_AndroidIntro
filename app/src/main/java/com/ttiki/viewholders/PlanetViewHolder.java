package com.ttiki.viewholders;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ttiki.adapters.PlanetsAdapter;
import com.uppa.monapp.databinding.PlanetItemBinding;
import com.ttiki.model.Planet;

public class PlanetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final PlanetItemBinding ui;
    private PlanetsAdapter.OnItemClickListener listener;

    public PlanetViewHolder(PlanetItemBinding ui) {
        super(ui.getRoot());
        this.ui = ui;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("Log", "itemClicked");
        if ((listener != null)) {
            this.listener.onItemClick(getAdapterPosition());
        }
    }

    public void setOnItemClickListener(PlanetsAdapter.OnItemClickListener i) {
        this.listener = i;
    }

    public void setPlanet(Planet pl) {
        ui.nomPlanet.setText(pl.getNom());
        ui.distance.setText(String.valueOf(pl.getDistance()));
        Glide.with(ui.getRoot()).load(pl.imageUrl).into(ui.planetLogo);

    }

}
