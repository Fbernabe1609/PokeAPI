package com.tareaapi.pokeapi.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.squareup.picasso.Picasso;
import com.tareaapi.pokeapi.MainActivity;
import com.tareaapi.pokeapi.R;
import com.tareaapi.pokeapi.models.Pokemon;
import com.tareaapi.pokeapi.models.PostPokemon;
import com.tareaapi.pokeapi.service.PokemonLoader;
import com.tareaapi.pokeapi.service.PostLoader;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonActivity extends AppCompatActivity{

    String pokemonName = PokemonAdapter.pokemonNameData;
    Pokemon pokemonStar = MainActivity.pokemonZ;
    Pokemon pokeGod;
    TextView types, species, baseExperience, pokemonNameTV, text, num;
    ImageView image;
    Button button;

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
        button = (Button) findViewById(R.id.button2);
        text = (TextView) findViewById(R.id.textView2);
        num = (TextView) findViewById(R.id.IDTextView);

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

        button.setOnClickListener(v -> {
            PostLoader postLoader = new PostLoader();
            Call<PostPokemon> call = postLoader.sendData(pokeGod.getName(),pokeGod.getId());
            call.enqueue(new Callback<PostPokemon>() {
                @Override
                public void onResponse(Call<PostPokemon> call, Response<PostPokemon> response) {
                    int id = response.body().getId();
                    try {
                        text.setText(text.getText() + " " + id);
                        text.setVisibility(View.VISIBLE);
                    } catch (Exception e) {
                        Toast.makeText(PokemonActivity.this, "Ha ocurrido un error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<PostPokemon> call, Throwable t) {
                    Toast.makeText(PokemonActivity.this, "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
                }
            });
        });
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
                String img = pokemon.getSprites().getFrontDefault();
                if (img != null) {
                    Picasso.get().load(img).into(image);
                }
                num.setText(num.getText() + " " + pokemon.getId());
                species.setText(species.getText() + " " + pokemon.getSpecies().getName());
                baseExperience.setText(baseExperience.getText() + " " + String.valueOf(pokemon.getBaseExperience()));
                pokeGod = pokemon;
            }
        } catch (Exception e) {
            Toast.makeText(PokemonActivity.this, "Ha ocurrido un error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}