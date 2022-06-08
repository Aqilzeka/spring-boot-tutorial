package com.learn.rabbit.order;

import com.learn.rabbit.amqp.RabbitMQMessageProducer;
import com.learn.rabbit.amqp.NotificationRequest;
import com.learn.rabbit.notification.NotificationConfig;
import com.learn.rabbit.payment.Payment;
import com.learn.rabbit.payment.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;
    private final PaymentService paymentService;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    @Transactional
    public Product orderProduct(ProductDTO product) {

        System.out.println(product);

        Product build = Product.builder()
                .userId(product.getUserId())
                .productName(product.getProductName())
                .totalAmount(product.getTotalAmount())
                .comment(product.getComment())
                .orderDateTime(LocalDateTime.now())
                .build();

        Product savedProduct = productRepo.save(build);

        Payment payment = Payment.builder()
                .amount(build.getTotalAmount())
                .dateTime(LocalDateTime.now())
                .method("CARD").build();
        paymentService.pay(payment);


        NotificationRequest notificationRequest = new NotificationRequest(savedProduct.getUserId(),
                savedProduct.getId(), String.format("%s has ordered", savedProduct.getProductName()));


        rabbitMQMessageProducer.publish(
                NotificationConfig.topicExchangeName,
                NotificationConfig.bindingName,
                notificationRequest);
        return savedProduct;
    }
}
