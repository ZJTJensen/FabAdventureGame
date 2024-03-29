package com.fabAdventure.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name ="DECKS")
public class Decks {
    @Column private String slug;
    @Column private String name;
    @Column private String format;
    @Column private String notes;
    @Column private String visibility;
    @Column private int cardBack;
    @Column private Date createdAt;
    @Column private int totalVotes;
    @Column private int myVote;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ArrayList<Cards> cards;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ArrayList<Cards> sideboard;
}