package com.fabAdventure.fabAdventure.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    private HikariDataSource dataSource;


    
  public UserService() {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl("jdbc:postgresql://" + INSTANCE_HOST + "/");
    config.setUsername(DB_USER); 
    config.setPassword(DB_PASS);
    config.setMaximumPoolSize(5);
    config.setMinimumIdle(5);
    config.setConnectionTimeout(10000); // 10 seconds
    config.setIdleTimeout(600000); // 10 minutes
    config.setMaxLifetime(1800000);
    this.dataSource = new HikariDataSource(config);
}
  

    public Users doesUserExist(String slug) throws SQLException, ClassNotFoundException {
        Users user = new Users();
        try (java.sql.Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
            "select * from users where slug = ?")){
            preparedStatement.setString(1, slug);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user.setSlug(slug);
                    user.setPhone(resultSet.getString("phoneNumber"));
                    user.setUserLevel(resultSet.getInt("userLevel"));
                    user.setUserName(resultSet.getString("userName"));
                }
            }
        }
        return user;
    }
    public void creteUser(String phone, Decks deck, String userName){
        try (java.sql.Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO users(slug, phoneNumber, username, userlevel) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, deck.getSlug());
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, userName);
            preparedStatement.setInt(4, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUserLevel(String slug, Integer newLevel) {
        try (java.sql.Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                 "UPDATE users SET userlevel = ? WHERE slug = ?")) {
            preparedStatement.setInt(1, newLevel);
            preparedStatement.setString(2, slug);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Cards> getCards(String slug) {
    ArrayList<Cards> cards = new ArrayList<>();
    String sql = "SELECT * FROM cards WHERE slug = ?";

    try (java.sql.Connection connection = dataSource.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, slug);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Cards card = new Cards();
            card.setIdentifier(resultSet.getString("identifier"));
            card.setSlug(resultSet.getString("slug"));
            cards.add(card);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return cards;
}

    public void resetUserLevel(String slug) {
        try (java.sql.Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                 "UPDATE users SET userlevel = 1 WHERE slug = ?")) {
            preparedStatement.setString(1, slug);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePhone(String slug, String newPhone) {
        try (java.sql.Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                 "UPDATE users SET phone = ? WHERE slug = ?")) {
            preparedStatement.setString(1, newPhone);
            preparedStatement.setString(2, slug);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void changeUserName(String slug, String newUserName) {
        try (java.sql.Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                 "UPDATE users SET username = ? WHERE slug = ?")) {
            preparedStatement.setString(1, newUserName);
            preparedStatement.setString(2, slug);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String slug) {
        try (java.sql.Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                 "DELETE FROM users WHERE slug = ?")) {
            preparedStatement.setString(1, slug);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserCards(String slug) {
        try (java.sql.Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                 "DELETE FROM cards WHERE slug = ?")) {
            preparedStatement.setString(1, slug);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCardToUserDeck( String slug, Cards card){
        try (java.sql.Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO cards(slug, identifier) VALUES (?, ?)")) {
       String identifier = card.getIdentifier();
            preparedStatement.setString(1, slug);
            preparedStatement.setString(2, identifier);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean getUsersInBracket(String slug){
        return true;
    }
    
}
