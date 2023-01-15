package com.tareaapi.pokeapi.service;

import com.tareaapi.pokeapi.models.Pokedex;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonLoader implements PokeAPI{

    PokeAPI pokeAPI;
    final String URL_BASE = "https://pokeapi.co/api/v2/";

    public PokemonLoader() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL_BASE).addConverterFactory(GsonConverterFactory.create()).build();
        pokeAPI = retrofit.create(PokeAPI.class);
    }

    @Override
    public Call<Pokedex> getPokedex() {
        return null;
    }

    @Override
    public Call<Pokedex> getPokemonData(String pokemonName) {
        return null;
    }

    @Override
    public Call<Pokedex> getPokemonData(int pokemonNum) {
        return null;
    }
}
