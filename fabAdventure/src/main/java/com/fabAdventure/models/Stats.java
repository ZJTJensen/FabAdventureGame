package com.fabAdventure.models;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Stats {
    @Column private String cost;
    @Column private String defense;
    @Column private String resource;
}
