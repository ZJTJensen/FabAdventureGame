package com.fabAdventure.models;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name ="CARDS")
public class Cards {
    @Column private String identifier;
    @Column private String name;
    @Column private String rarity;
    @Embedded private Stats stats;
    @Column private String text;
    @ElementCollection
    private ArrayList<String> keywords;
    @Column private String flavour;
    @Column private String comments;
    @Column private String image;
    @Column private int total;
}
