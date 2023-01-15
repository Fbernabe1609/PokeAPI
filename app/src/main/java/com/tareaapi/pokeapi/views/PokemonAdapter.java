package com.tareaapi.pokeapi.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tareaapi.pokeapi.R;
import com.tareaapi.pokeapi.models.PokemonList;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    List<PokemonList> pokemons;
    Context context;

    public PokemonAdapter(List<PokemonList> pokemons, Context context) {
        this.pokemons = pokemons;
        this.context = context;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_list_item,parent,false);
        return new PokemonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        final int num = position;
        holder.pokemonName.setText(pokemons.get(num).getName());
        holder.pokemonContainer.setOnClickListener(view -> {
            String url = pokemons.get(num).getUrl();
        });
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }
}
