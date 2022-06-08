package com.learn.rabbit.notification;

import com.learn.rabbit.amqp.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepo notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .customerId(notificationRequest.getCustomerId())
                        .orderId(notificationRequest.getOrderId())
                        .sender("My Company")
                        .message(notificationRequest.getMessage())
                        .sentAt(LocalDateTime.now())
                        .build()
        );

        // TODO: implement firebase for android
        // TODO: email notification
    }
}
