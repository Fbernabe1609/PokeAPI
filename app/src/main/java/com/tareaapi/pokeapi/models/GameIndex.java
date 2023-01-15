package com.tareaapi.pokeapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GameIndex {

    @SerializedName("game_index")
    @Expose
    private int gameIndex;
    @SerializedName("version")
    @Expose
    private Version version;

    public int getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(int gameIndex) {
        this.gameIndex = gameIndex;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

}
