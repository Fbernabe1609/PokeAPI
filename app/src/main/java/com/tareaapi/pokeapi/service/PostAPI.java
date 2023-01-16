package com.tareaapi.pokeapi.service;

import com.tareaapi.pokeapi.models.PostPokemon;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostAPI {
    @FormUrlEncoded
    @POST("users/")
    Call<PostPokemon> sendData(@Field("pokemon_name") String pokemonNameRequire, @Field("pokemon_id") int pokemonId);
}
