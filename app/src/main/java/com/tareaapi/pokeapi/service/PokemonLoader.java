package com.tareaapi.pokeapi.service;

import com.tareaapi.pokeapi.models.Pokedex;
import com.tareaapi.pokeapi.models.Pokemon;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonLoader implements PokeAPI{

    PokeAPI pokeAPI;
    final String URL_BASE = "https://pokeapi.co/api/v2/";

    public PokemonLoader() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        pokeAPI = retrofit.create(PokeAPI.class);
    }

    @Override
    public Call<Pokedex> getPokedex() {
        return pokeAPI.getPokedex();
    }

    @Override
    public Call<Pokemon> getPokemonData(String pokemonName) {
        return pokeAPI.getPokemonData(pokemonName);
    }

    @Override
    public Call<Pokemon> getPokemonData(int pokemonNum) {
        return pokeAPI.getPokemonData(pokemonNum);
    }

}
