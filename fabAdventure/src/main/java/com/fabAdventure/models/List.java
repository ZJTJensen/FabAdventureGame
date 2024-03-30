package com.fabAdventure.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name ="LIST")
public class List {
	@Column private String cardName;
	@Column private String cardRarity;
	@Column private String armorFlag;

        
        public String getCardName() {
            return cardName;
        }
        public void setCardName(String cardName) {
            this.cardName = cardName;
        }
        public String getCardRarity() {
            return cardRarity;
        }
        public void setCardRarity(String cardRarity) {
            this.cardRarity = cardRarity;
        }
        public String getArmorFlag() {
            return armorFlag;
        }
        public void setArmorFlag(String armorFlag) {
            this.armorFlag = armorFlag;
        }
}