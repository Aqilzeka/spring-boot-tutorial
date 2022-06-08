//package org.springframework.amqp.tutorials.direct;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DirectConfiguration {
//
//    @Bean
//    Queue primarystudentsQueue() {
//        return new Queue("primarystudentsQueue", false);
//    }
//
//    @Bean
//    Queue secondarystudentsQueue() {
//        return new Queue("secondarystudentsQueue", false);
//    }
//
//    @Bean
//    Queue collegestudentsQueue() {
//        return new Queue("collegestudentsQueue", false);
//    }
//
//
//    @Bean
//    DirectExchange exchange() {
//        return new DirectExchange("direct-exchange");
//    }
//
//    @Bean
//    Binding primarystudentsBinding(Queue primarystudentsQueue, DirectExchange exchange) {
//        return BindingBuilder.bind(primarystudentsQueue).to(exchange).with("queue.primarystudents");
//    }
//
//    @Bean
//    Binding secondarystudentsBinding(Queue secondarystudentsQueue, DirectExchange exchange) {
//        return BindingBuilder.bind(secondarystudentsQueue).to(exchange).with("queue.secondarystudents");
//    }
//
//    @Bean
//    Binding collegestudentsBinding(Queue collegestudentsQueue, DirectExchange exchange) {
//        return BindingBuilder.bind(collegestudentsQueue).to(exchange).with("queue.collegestudents");
//    }
//}