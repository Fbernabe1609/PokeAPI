package com.tareaapi.pokeapi.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.tareaapi.pokeapi.MainActivity;
import com.tareaapi.pokeapi.R;
import com.tareaapi.pokeapi.models.Pokemon;
import com.tareaapi.pokeapi.models.PokemonList;
import com.tareaapi.pokeapi.models.Sprites;
import com.tareaapi.pokeapi.service.PokemonLoader;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonActivity extends AppCompatActivity{

    String pokemonName = PokemonAdapter.pokemonNameData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        Objects.requireNonNull(getSupportActionBar()).hide();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        PokemonLoader loader = new PokemonLoader();
        Call<Pokemon> call = loader.getPokemonData(pokemonName);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon pokemon = response.body();
                System.out.println(pokemon.getName());
                Toast.makeText(PokemonActivity.this, pokemon.getName(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Toast.makeText(PokemonActivity.this, "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
            }
        });
    }
}