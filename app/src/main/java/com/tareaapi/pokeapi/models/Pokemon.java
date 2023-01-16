package com.tareaapi.pokeapi.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {

    @SerializedName("abilities")
    @Expose
    private List<Abilities> abilities = null;

    @SerializedName("game_indices")
    @Expose
    private List<GameIndex> gameIndices = null;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("base_experience")
    @Expose
    private int baseExperience;

    @SerializedName("moves")
    @Expose
    private List<Moves> moves = null;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("order")
    @Expose
    private int order;

    @SerializedName("species")
    @Expose
    private Species species;

    @SerializedName("sprites")
    @Expose
    private Sprites sprites;

    @SerializedName("types")
    @Expose
    private List<Types> types = null;

    @SerializedName("weight")
    @Expose
    private int weight;

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public List<GameIndex> getGameIndices() {
        return gameIndices;
    }

    public void setGameIndices(List<GameIndex> gameIndices) {
        this.gameIndices = gameIndices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }
}