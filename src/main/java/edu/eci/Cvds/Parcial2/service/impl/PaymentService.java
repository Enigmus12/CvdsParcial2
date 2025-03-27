package edu.eci.Cvds.Parcial2.service.impl;

import edu.eci.Cvds.Parcial2.dto.PaymentDTO;
import edu.eci.Cvds.Parcial2.model.Payment;
import edu.eci.Cvds.Parcial2.service.interfaces.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(PaymentDTO paymentDTO) {
        double calculatedTotal = paymentDTO.getItems().stream()
                .mapToDouble(item -> item.getQuantity() * item.getUnitPrice())
                .sum();

        Payment payment = new Payment();
        payment.setUserId(paymentDTO.getUserId());
        payment.setItems(paymentDTO.getItems());
        payment.setTotalAmount(calculatedTotal);
        payment.setDate(LocalDate.parse(paymentDTO.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        if (calculatedTotal <= 0) {
            payment.setStatus("DECLINED");
            payment.setResponseMessage("Invalid total amount");
        } else {
            payment.setStatus("APPROVED");
            payment.setResponseMessage("Payment successful");
        }

        return paymentRepository.save(payment);
    }

    public List<Payment> getPaymentsByUserId(String userId) {
        return paymentRepository.findByUserId(userId);
    }

    public List<Payment> getAllProducts() {
        return paymentRepository.findAll();
    }

}
