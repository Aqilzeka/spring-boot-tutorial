package com.learn.rabbit.order;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Setter
@Getter
public class ProductDTO {
    private Long userId;
    private String productName;
    private BigDecimal totalAmount;
    private String comment;
}
