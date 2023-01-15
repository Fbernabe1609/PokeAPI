package com.tareaapi.pokeapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Ability {

    @SerializedName("ability")
    @Expose
    private Ability__1 ability;
    @SerializedName("is_hidden")
    @Expose
    private boolean isHidden;
    @SerializedName("slot")
    @Expose
    private int slot;

    public Ability__1 getAbility() {
        return ability;
    }

    public void setAbility(Ability__1 ability) {
        this.ability = ability;
    }

    public boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

}
