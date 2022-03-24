package com.ttiki.mynamemycountry.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ttiki.mynamemycountry.model.Country;
import com.ttiki.mynamemycountry.viewholders.CountryViewHolder;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    ArrayList<Country> countries;

    public CountryAdapter(ArrayList<Country> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CountryItemBinding ui = CountryItemBinding.infalte(LayoutInflater.from(parent.getContext()), parent, false);
        return new CountryViewHolder(ui);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.setCountry(country);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
