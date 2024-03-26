package com.fabAdventure.models;

import jakarta.persistence.Column;


public class UsersRequest {

    @Column private String user;

    public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
}
