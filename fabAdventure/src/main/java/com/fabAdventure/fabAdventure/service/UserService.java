package com.fabAdventure.fabAdventure.service;

import org.springframework.stereotype.Service;

import com.fabAdventure.models.Cards;
import com.fabAdventure.models.Decks;

@Service
public class UserService {

    public boolean doesUserExist(String slug){
        return true;
    }
    public boolean creteUser(String phone, Decks deck){
        return true;
    }
    public boolean addCardToUserDeck(Cards card){
        return true;

    }
    public boolean getUsersInBracket(String slug){
        return true;
    }
    
}
