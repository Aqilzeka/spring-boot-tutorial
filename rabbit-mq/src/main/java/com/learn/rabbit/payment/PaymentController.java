package com.learn.rabbit.payment;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public Payment pay(@RequestBody Payment payment) {
        return paymentService.pay(payment);
    }
}
