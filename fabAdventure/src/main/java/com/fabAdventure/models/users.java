package com.fabAdventure.models;
import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="USERS")
public class users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column private Integer id;
    @Column private String user;
    @Column private String phone;


    @Column private Date createdDateTime;
    @Column private Date updatedDateTime;



    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

    public String getCreatedPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

    public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

    public Date getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}
	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
  
}




