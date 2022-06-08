package com.learn.rabbit.payment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {
    private final PaymentRepo paymentRepo;

    public Payment pay(Payment payment) {
        Payment save = paymentRepo.save(payment);

        try {
            // TODO: implement card-ms
            save.setIsPay(Boolean.TRUE);
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return save;
    }
}
