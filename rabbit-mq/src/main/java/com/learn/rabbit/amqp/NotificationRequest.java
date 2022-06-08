package com.learn.rabbit.amqp;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest implements Serializable {
    private Long customerId;
    private Long orderId;
    private String message;
}
