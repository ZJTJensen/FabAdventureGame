package com.fabAdventure.models;

import jakarta.persistence.Column;


public class UsersRequest {

    @Column private String slug;
	@Column private Cards card;
	@Column private String phoneNumber; 
	@Column private Decks deck; 
    @Column private String user; 
    @Column private Integer userLevel; 

    public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public Cards getCard() {
        return this.card;
    }

    public void setCard(Cards card) {
        this.card = card;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Decks getDeck() {
        return this.deck;
    }

    public void setDeck(Decks deck) {
        this.deck = deck;
    }
    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public Integer getUserLevel() {
        return this.userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

}
