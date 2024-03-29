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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public int getCardBack() {
        return cardBack;
    }

    public void setCardBack(int cardBack) {
        this.cardBack = cardBack;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public int getMyVote() {
        return myVote;
    }

    public void setMyVote(int myVote) {
        this.myVote = myVote;
    }

    public ArrayList<Cards> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Cards> cards) {
        this.cards = cards;
    }

    public ArrayList<Cards> getSideboard() {
        return sideboard;
    }

    public void setSideboard(ArrayList<Cards> sideboard) {
        this.sideboard = sideboard;
    }
}