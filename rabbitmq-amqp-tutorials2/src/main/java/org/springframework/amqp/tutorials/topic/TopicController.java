//package org.springframework.amqp.tutorials.topic;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(value = "/topic/")
//public class TopicController {
//
//    @Autowired
//    private AmqpTemplate amqpTemplate;
//
//    @GetMapping(value = "/sendmsg")
//    public String producer(@RequestParam("exchange") String exchange, @RequestParam("routingKey") String routingKey,
//                           @RequestParam("msg") String msg) {
//
//        amqpTemplate.convertAndSend(exchange, routingKey, msg);
//
//        return "Message Successfully sent---- Method used Topic Exchange";
//    }
//
//}