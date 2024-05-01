package com.fabAdventure.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name ="PRINTINGS")
public class Printings {
    @Column private String finish;
    @Column private Sku sku;

        // Getter and setter for 'finish'
        public String getFinish() {
            return finish;
        }
    
        public void setFinish(String finish) {
            this.finish = finish;
        }
    
        // Getter and setter for 'sku'
        public Sku getSku() {
            return sku;
        }
    
        public void setSku(Sku sku) {
            this.sku = sku;
        }
}
