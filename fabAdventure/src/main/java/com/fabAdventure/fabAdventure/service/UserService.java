package com.fabAdventure.fabAdventure.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

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
        try {
            dataSource.getConnection().prepareStatement(
                "insert into users(slug, phoneNumber, userName, userLevel)"
                +" values ('"
                + deck.getSlug() + "','" + phone 
                + "', '" + userName + "', '1')"
            ).executeQuery().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addCardToUserDeck( String slug, Cards card){
        try {
            Optional<String> sku = card.getPrintings().stream()
            .filter(printing -> "Regular".equals(printing.getFinish()))
            .map(printing -> printing.getSku().getSku())
            .findFirst();
            if (!sku.isPresent()) {
                sku = card.getPrintings().stream()
                    .map(printing -> printing.getSku().getSku())
                    .findFirst();
            }
            dataSource.getConnection().prepareStatement(
                "insert into cards(slug, identifier)"+
                " values ('" + slug + "','" + sku + "')"
            ).executeQuery().close();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public boolean getUsersInBracket(String slug){
        return true;
    }
    
}
