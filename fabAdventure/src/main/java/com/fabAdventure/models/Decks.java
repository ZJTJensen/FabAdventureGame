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
@Table(name ="DECKS")
public class Decks {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column private Integer user_id;
	@Column private String fabdb_link;
	@Column private ArrayList<List> deck_list;

    
    public Integer getId() {
		return user_id;
	}
	public void setId(Integer id) {
		this.user_id = id;
	}


    public String getLink() {
		return fabdb_link;
	}
	public void setLink(String Link) {
		this.fabdb_link = Link;
	}
    
    public ArrayList<List> getDeckList() {
        return deck_list;
    }
    public void setDeckList(ArrayList<List> deck_list) {
        this.deck_list = deck_list;
    }
}
