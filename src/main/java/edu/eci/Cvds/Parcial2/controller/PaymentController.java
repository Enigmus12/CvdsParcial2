package edu.eci.Cvds.Parcial2.controller;

import edu.eci.Cvds.Parcial2.dto.PaymentDTO;
import edu.eci.Cvds.Parcial2.model.Payment;
import edu.eci.Cvds.Parcial2.service.impl.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-service")
@CrossOrigin(origins = "*") // Permite acceso desde cualquier lado
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/pay")
    public Payment makePayment(@RequestBody PaymentDTO request) {
        return paymentService.processPayment(request);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Payment>> getUserPayments(@PathVariable String userId) {
        return ResponseEntity.ok(paymentService.getPaymentsByUserId(userId));
    }

    @GetMapping("/user")
    public List<Payment> Payment() {
        return paymentService.getAllProducts();
    }
}
