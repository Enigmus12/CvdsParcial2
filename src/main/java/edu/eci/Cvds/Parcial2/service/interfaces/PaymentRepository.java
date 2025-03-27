package edu.eci.Cvds.Parcial2.service.interfaces;

import edu.eci.Cvds.Parcial2.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
    List<Payment> findByUserId(String userId);
}
