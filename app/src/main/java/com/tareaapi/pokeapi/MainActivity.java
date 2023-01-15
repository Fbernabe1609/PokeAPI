package com.tareaapi.pokeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.tareaapi.pokeapi.models.Pokedex;
import com.tareaapi.pokeapi.service.PokemonLoader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PokemonLoader pokemonLoader = new PokemonLoader();
        Call<Pokedex> call = pokemonLoader.getPokedex();
        call.enqueue(new Callback<Pokedex>() {
            @Override
            public void onResponse(Call<Pokedex> call, Response<Pokedex> response) {

            }

            @Override
            public void onFailure(Call<Pokedex> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
            }
        });
    }
}