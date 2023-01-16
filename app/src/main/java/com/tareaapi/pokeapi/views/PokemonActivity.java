package com.tareaapi.pokeapi.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.tareaapi.pokeapi.R;
import com.tareaapi.pokeapi.models.Pokemon;
import com.tareaapi.pokeapi.service.PokemonLoader;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonActivity extends AppCompatActivity{

    String pokemonName = PokemonAdapter.pokemonNameData;
    TextView types, species, baseExperience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        Objects.requireNonNull(getSupportActionBar()).hide();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        types = (TextView) findViewById(R.id.TypesTextView);
        species = (TextView) findViewById(R.id.SpeciesTextView);
        baseExperience = (TextView) findViewById(R.id.BaseExperienceTextView);

        PokemonLoader loader = new PokemonLoader();
        Call<Pokemon> call = loader.getPokemonData(pokemonName);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon pokemon = response.body();
                String text = types.getText().toString();
                for (int i = 0; i < pokemon.getTypes().size(); i++){
                    text = text + pokemon.getTypes().get(i) + " ";
                }
                types.setText(text);
                species.setText(pokemon.getSpecies().getName());
//                baseExperience.setText(pokemon.getBaseExperience());
                Toast.makeText(PokemonActivity.this, pokemon.getName(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Toast.makeText(PokemonActivity.this, "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
            }
        });
    }
}