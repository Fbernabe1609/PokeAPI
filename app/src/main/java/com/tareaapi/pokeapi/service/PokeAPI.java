package com.tareaapi.pokeapi.service;

import com.tareaapi.pokeapi.models.Pokedex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeAPI {
    @GET("pokemon")
    Call<Pokedex> getPokedex();
    @GET("pokemon/{pokemonName}")
    Call<Pokedex> getPokemonData(@Path("pokemonName") String pokemonName);
    @GET("pokemon/{pokemonNum}")
    Call<Pokedex> getPokemonData(@Path("pokemonName") int pokemonNum);
}
