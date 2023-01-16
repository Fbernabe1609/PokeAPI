package com.tareaapi.pokeapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Abilities {

    @SerializedName("ability")
    @Expose
    private Ability ability;
    @SerializedName("is_hidden")
    @Expose
    private boolean isHidden;
    @SerializedName("slot")
    @Expose
    private int slot;

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
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
