package com.fabAdventure.models;

import java.util.ArrayList;


public class UserAndCards {
    private Users user;
    private ArrayList<Cards> cards;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public ArrayList<Cards> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Cards> cards) {
        this.cards = cards;
    }
}
