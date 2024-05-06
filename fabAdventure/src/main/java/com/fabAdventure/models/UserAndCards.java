package com.fabAdventure.models;

import java.util.ArrayList;


public class UserAndCards {
    private Users user;
    private ArrayList<?> cards;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public ArrayList<?> getCards() {
        return cards;
    }

    public void setCards(ArrayList<?> cards) {
        this.cards = cards;
    }
}
