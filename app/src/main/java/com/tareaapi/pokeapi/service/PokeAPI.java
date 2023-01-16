package com.tareaapi.pokeapi.service;

import com.tareaapi.pokeapi.models.Pokedex;
import com.tareaapi.pokeapi.models.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeAPI {
    @GET("pokemon/")
    Call<Pokedex> getPokedex();
    @GET("pokemon/{pokemonName}")
    Call<Pokemon> getPokemonData(@Path("pokemonName") String pokemonName);
    @GET("pokemon/{pokemonNum}")
    Call<Pokemon> getPokemonData(@Path("pokemonNum") int pokemonNum);
}
