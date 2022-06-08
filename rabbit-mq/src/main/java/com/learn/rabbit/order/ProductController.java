package com.learn.rabbit.order;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

    private ProductService productService;

    @PostMapping
    public Product orderProduct(@RequestBody ProductDTO product) {
        return productService.orderProduct(product);
    }

    @GetMapping
    public String test() {
        return "Test";
    }
}
