package com.tareaapi.pokeapi.service;

import com.tareaapi.pokeapi.models.PostPokemon;
import com.tareaapi.pokeapi.models.PostPokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostAPI {
    @POST("users/")
    Call<PostPokemon> sendData();
    @GET("users/{name}")
    Call<PostPokemonResponse> getData(@Path("name") String name);
}
