package com.learn.rabbit.notification.rabbitmq;

import com.learn.rabbit.amqp.NotificationRequest;
import com.learn.rabbit.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class NotificationConsumer {
    private final NotificationService notificationService;

    @RabbitListener(queues = "notify-queue")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Consumed {} from queue", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
