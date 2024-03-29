package com.fabAdventure.models;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Stats {
    @Column private String cost;
    @Column private String defense;
    @Column private String resource;
    
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
