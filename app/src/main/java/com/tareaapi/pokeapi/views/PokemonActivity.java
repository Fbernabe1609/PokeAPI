package com.tareaapi.pokeapi.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.squareup.picasso.Picasso;
import com.tareaapi.pokeapi.MainActivity;
import com.tareaapi.pokeapi.R;
import com.tareaapi.pokeapi.models.Pokemon;
import com.tareaapi.pokeapi.service.PokemonLoader;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonActivity extends AppCompatActivity{

    String pokemonName = PokemonAdapter.pokemonNameData;
    Pokemon pokemonStar = MainActivity.pokemonZ;
    TextView types, species, baseExperience, pokemonNameTV;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        Objects.requireNonNull(getSupportActionBar()).hide();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        pokemonNameTV = (TextView) findViewById(R.id.pokemonName2);
        types = (TextView) findViewById(R.id.TypesTextView);
        species = (TextView) findViewById(R.id.SpeciesTextView);
        baseExperience = (TextView) findViewById(R.id.BaseExperienceTextView);
        image = (ImageView) findViewById(R.id.pokemonSprite);

        PokemonLoader loader = new PokemonLoader();
        if (pokemonStar == null) {
            Call<Pokemon> call = loader.getPokemonData(pokemonName);
            call.enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    Pokemon pokemon = response.body();
                    getData(pokemon);
                }

                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {
                    Toast.makeText(PokemonActivity.this, "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
                }
            });
        } else {
            getData(pokemonStar);
        }
    }

    @Override
    protected void onDestroy() {
        PokemonAdapter.pokemonNameData = null;
        MainActivity.pokemonZ = null;
        super.onDestroy();
    }

    public void getData(Pokemon pokemon) {
        try {
            if (pokemon != null) {
                String text = types.getText().toString();
                if (pokemon.getTypes().size() == 2) {
                    text = text + " " + pokemon.getTypes().get(0).getType().getName() + "/" + pokemon.getTypes().get(1).getType().getName();
                } else {
                    text = text + " " + pokemon.getTypes().get(0).getType().getName();
                }
                types.setText(text);
                pokemonNameTV.setText(pokemon.getName().toUpperCase());
                Picasso.get().load(pokemon.getSprites().getFrontDefault()).into(image);

                species.setText(species.getText() + " " + pokemon.getSpecies().getName());
                baseExperience.setText(baseExperience.getText() + " " + String.valueOf(pokemon.getBaseExperience()));
            }
        } catch (Exception e) {
            Toast.makeText(PokemonActivity.this, "Ha ocurrido un error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}