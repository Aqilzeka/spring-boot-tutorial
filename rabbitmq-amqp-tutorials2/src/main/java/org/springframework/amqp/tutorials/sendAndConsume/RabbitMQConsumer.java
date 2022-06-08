package org.springframework.amqp.tutorials.sendAndConsume;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.tutorials.Employee;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "${javainuse.rabbitmq.queue}")
    public void receivedMessage(Employee employee) {
        System.out.println("Received Message From RabbitMQ: " + employee);
    }
}