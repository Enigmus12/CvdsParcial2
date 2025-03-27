package edu.eci.Cvds.Parcial2.model;

import edu.eci.Cvds.Parcial2.dto.PaymentDTO;
import jakarta.persistence.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "Parcial")
public class Payment {
    @Id
    private String userId;
    private List<Item> items;
    private Double totalAmount;
    private String status;
    private String responseMessage;
    private LocalDate date;

    @PersistenceCreator

    public Payment() {
    }

    public Payment(PaymentDTO paymentDTO) {
        this.userId = paymentDTO.getUserId();
        this.items = paymentDTO.getItems();
        this.date = LocalDate.parse(paymentDTO.getDate());
    }



    public String getUserId() {return userId;}
    public void setUserId(String userId) {this.userId = userId;}

    public List<Item> getItems() {return items;}
    public void setItems(List<Item> items) {this.items = items;}

    public Double getTotalAmount() {return totalAmount;}
    public void setTotalAmount(Double totalAmount) {this.totalAmount = totalAmount;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public String getResponseMessage() {return responseMessage;}
    public void setResponseMessage(String responseMessage) {this.responseMessage = responseMessage;}

    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {this.date = date;}

}
