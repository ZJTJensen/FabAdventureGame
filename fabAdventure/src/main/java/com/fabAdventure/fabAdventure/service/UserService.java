package com.fabAdventure.fabAdventure.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.fabAdventure.models.Cards;
import com.fabAdventure.models.Decks;
import com.fabAdventure.models.Users;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Service
public class UserService {

    private static final String INSTANCE_HOST = System.getenv("INSTANCE_HOST");
    private static final String DB_USER = System.getenv("DB_USER");
    private static final String DB_PASS = System.getenv("DB_PASS");

    
  public static DataSource createConnectionPool() {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl("jdbc:postgresql://" + INSTANCE_HOST + "/");
    config.setUsername(DB_USER); 
    config.setPassword(DB_PASS);
    return new HikariDataSource(config);
  }
  

    public Users doesUserExist(String slug) throws SQLException, ClassNotFoundException{
        Users user = new Users();
        DataSource dataSource = createConnectionPool();
        ResultSet resultSet = dataSource.getConnection().prepareStatement("select * from users where slug = '" + slug + "'").executeQuery();
        while(resultSet.next()){
            user.setSlug(slug);
            user.setPhone(resultSet.getString("phoneNumber"));
            user.setUserLevel(resultSet.getInt("userLevel"));
            user.setUserName(resultSet.getString("userName"));
        }
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
