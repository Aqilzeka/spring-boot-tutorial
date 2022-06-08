package com.learn.rabbit.notification;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
public class Notification {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private Long orderId;
    private String sender;
    private String message;
    private LocalDateTime sentAt;
}
