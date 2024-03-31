package com.fabAdventure.models;
import java.util.Date;

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
  
}




