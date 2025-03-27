package edu.eci.Cvds.Parcial2.model;

import org.springframework.data.annotation.PersistenceCreator;

public class Item {
    private String name;
    private double unitPrice;
    private int quantity;

    @PersistenceCreator
    public Item() {
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public double getUnitPrice() {return unitPrice;}
    public void setUnitPrice(double unitPrice) {this.unitPrice = unitPrice;}

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

}
