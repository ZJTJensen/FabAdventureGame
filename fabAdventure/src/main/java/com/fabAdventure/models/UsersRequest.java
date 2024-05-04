package com.fabAdventure.models;

import jakarta.persistence.Column;


public class UsersRequest {

    @Column private String slug;
	@Column private Cards card;
	@Column private String phone; 
	@Column private Decks deck; 
    @Column private String userName; 
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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Decks getDeck() {
        return this.deck;
    }

    public void setDeck(Decks deck) {
        this.deck = deck;
    }
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Integer getUserLevel() {
        return this.userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

}
