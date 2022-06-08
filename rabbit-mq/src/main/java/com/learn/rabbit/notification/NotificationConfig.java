package com.learn.rabbit.notification;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class NotificationConfig {
    public static final String topicExchangeName = "notify-exchange";
    public static final String queueName = "notify-queue";
    public static final String bindingName = "binging-name";

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(queueName);
    }

    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder
                .bind(notificationQueue())
                .to(internalTopicExchange())
                .with(bindingName);
    }


}
