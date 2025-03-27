package edu.eci.Cvds.Parcial2.dto;

import edu.eci.Cvds.Parcial2.model.Item;

import java.util.List;

public class PaymentDTO {
    private String userId;
    private List<Item> items;
    private String date;

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
