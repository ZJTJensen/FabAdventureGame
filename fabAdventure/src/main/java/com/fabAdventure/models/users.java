package com.fabAdventure.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="USERS")
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column private String slug;
    @Column private String phone;
	@Column private String userName;
	@Column private int userLevel;
	// @Column private Decks deck;



    public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}

    public String getCreatedPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getUserLevel() {
		return this.userLevel;
	}
	
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
  
}




