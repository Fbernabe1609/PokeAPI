package com.tareaapi.pokeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tareaapi.pokeapi.models.Pokedex;
import com.tareaapi.pokeapi.models.Pokemon;
import com.tareaapi.pokeapi.models.PokemonList;
import com.tareaapi.pokeapi.service.PokemonLoader;
import com.tareaapi.pokeapi.views.PokemonAdapter;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView pokemonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        Objects.requireNonNull(getSupportActionBar()).hide();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        pokemonList = (RecyclerView) findViewById(R.id.PokemonListRV);
        PokemonLoader pokemonLoader = new PokemonLoader();
        Call<Pokedex> call = pokemonLoader.getPokedex();
        call.enqueue(new Callback<Pokedex>() {
            @Override
            public void onResponse(Call<Pokedex> call, Response<Pokedex> response) {
                List<PokemonList> pokemons = response.body().getResults();
                PokemonAdapter adapter = new PokemonAdapter(pokemons,MainActivity.this);
                pokemonList.setAdapter(adapter);
                pokemonList.setHasFixedSize(true);
                RecyclerView.LayoutManager manager = new LinearLayoutManager(MainActivity.this);
                pokemonList.setLayoutManager(manager);
            }

            @Override
            public void onFailure(Call<Pokedex> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
            }
        });
    }
}