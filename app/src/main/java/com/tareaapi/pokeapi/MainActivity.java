package com.tareaapi.pokeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tareaapi.pokeapi.models.Pokedex;
import com.tareaapi.pokeapi.models.Pokemon;
import com.tareaapi.pokeapi.models.PokemonList;
import com.tareaapi.pokeapi.service.PokemonLoader;
import com.tareaapi.pokeapi.views.PokemonActivity;
import com.tareaapi.pokeapi.views.PokemonAdapter;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView pokemonList;
    Button search;
    EditText pokemonSearch;
    public static Pokemon pokemonZ;

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
        search = (Button) findViewById(R.id.button);
        pokemonSearch = (EditText) findViewById(R.id.NumNamePokemonEditText);
        PokemonLoader pokemonLoader = new PokemonLoader();
        search.setOnClickListener(v -> {
            String txt = pokemonSearch.getText().toString();
            if (!txt.isEmpty()) {
                Call<Pokemon> call = pokemonLoader.getPokemonData(txt);
                call.enqueue(new Callback<Pokemon>() {
                    @Override
                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                        Pokemon pokemon = response.body();
                        try {
                            if (pokemon != null) {
                                pokemonZ = pokemon;
                                startActivity(new Intent(MainActivity.this,PokemonActivity.class));
                                pokemonSearch.setText("");
                            } else {
                                Toast.makeText(MainActivity.this, "No existe ese Pokemon", Toast.LENGTH_LONG).show();
                            }
                        } catch (Exception e) {
                            Toast.makeText(MainActivity.this, "Ha ocurrido un error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Pokemon> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
                    }
                });
            } else {
                Toast.makeText(MainActivity.this, "Completa el campo.", Toast.LENGTH_LONG).show();
            }
        });
        Call<Pokedex> call = pokemonLoader.getPokedex();
        call.enqueue(new Callback<Pokedex>() {
            @Override
            public void onResponse(Call<Pokedex> call, Response<Pokedex> response) {
                List<PokemonList> pokemons = response.body().getResults();
                try {
                    if (pokemons != null) {
                        pokemonList.setAdapter(new PokemonAdapter(pokemons,MainActivity.this));
                        pokemonList.setHasFixedSize(true);
                        pokemonList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    } else {
                        Toast.makeText(MainActivity.this, "Ha ocurrido un error", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Ha ocurrido un error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Pokedex> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
            }
        });
    }
}