package com.tareaapi.pokeapi.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {

    @SerializedName("abilities")
    @Expose
    private List<Ability> abilities = null;
    @SerializedName("forms")
    @Expose
    private List<Form> forms = null;
    @SerializedName("game_indices")
    @Expose
    private List<GameIndex> gameIndices = null;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("is_default")
    @Expose
    private boolean isDefault;
    @SerializedName("moves")
    @Expose
    private List<Move> moves = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("order")
    @Expose
    private int order;
    @SerializedName("past_types")
    @Expose
    private List<Object> pastTypes = null;
    @SerializedName("species")
    @Expose
    private Species species;
    @SerializedName("sprites")
    @Expose
    private Sprites sprites;
    @SerializedName("types")
    @Expose
    private List<Type> types = null;
    @SerializedName("weight")
    @Expose
    private int weight;

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
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

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
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

    public List<Object> getPastTypes() {
        return pastTypes;
    }

    public void setPastTypes(List<Object> pastTypes) {
        this.pastTypes = pastTypes;
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

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}