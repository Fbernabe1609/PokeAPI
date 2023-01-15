package com.tareaapi.pokeapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Move {

    @SerializedName("move")
    @Expose
    private Move__1 move;

    public Move__1 getMove() {
        return move;
    }

    public void setMove(Move__1 move) {
        this.move = move;
    }

}
