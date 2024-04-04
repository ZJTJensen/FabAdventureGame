package com.fabAdventure.fabAdventure.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.fabAdventure.models.Cards;
import com.fabAdventure.models.Decks;
import com.fabAdventure.models.Users;

@Service
public class UserService {

    private String username = "root";
    private String password = "root";
    private String url = "jdbc:mysql://localhost:3306/";

    public Users doesUserExist(String slug) throws SQLException, ClassNotFoundException{
        Users user = new Users();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(this.url + "USERS", this.username, this.password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS WHERE slug = '" + slug + "'");
        user.setSlug(slug);
        user.setPhone(resultSet.getString("phoneNumber"));
        user.setUserLevel(resultSet.getInt("userLevel"));
        user.setUserName(resultSet.getString("userName"));
        while(resultSet.next()){
            return user;
        }
        connection.close();
        statement.close();
        resultSet.close();
        return user;
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
