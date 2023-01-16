package com.tareaapi.pokeapi.service;

import com.tareaapi.pokeapi.models.PostPokemon;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostLoader implements PostAPI{

    PostAPI postAPI;
    final String URL_BASE = "https://jsonplaceholder.typicode.com/";

    public PostLoader(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postAPI = retrofit.create(PostAPI.class);
    }


    @Override
    public Call<PostPokemon> sendData(String pokemonNameRequire, int pokemonId) {
        return postAPI.sendData(pokemonNameRequire, pokemonId);
    }
}
