package com.fabAdventure.fabAdventure.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.fabAdventure.models.Cards;
import com.fabAdventure.models.Decks;

@Service
public class UserService {

    public boolean doesUserExist(String slug) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/USERS";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS WHERE slug = '" + slug + "'");
        while(resultSet.next()){
            return true;
        }
        connection.close();
        statement.close();
        resultSet.close();
        return false;
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
