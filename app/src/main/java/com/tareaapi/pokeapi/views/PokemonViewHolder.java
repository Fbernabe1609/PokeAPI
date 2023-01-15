package com.tareaapi.pokeapi.views;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tareaapi.pokeapi.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PokemonViewHolder extends RecyclerView.ViewHolder {

    LinearLayout pokemonContainer;
    TextView pokemonName;

    public PokemonViewHolder(@NonNull View view) {
        super(view);
        pokemonName = (TextView) view.findViewById(R.id.pokemonName);
        pokemonContainer = (LinearLayout) view.findViewById(R.id.pokemonContainer);
    }
}
