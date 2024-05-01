package com.fabAdventure.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name ="SKU")
public class Sku {
    @Column private String sku;

    // Getter for 'sku'
    public String getSku() {
        return sku;
    }

    // Setter for 'sku'
    public void setSku(String sku) {
        this.sku = sku;
    }
}
