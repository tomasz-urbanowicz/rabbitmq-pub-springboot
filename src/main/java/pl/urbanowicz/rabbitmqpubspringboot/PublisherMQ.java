package pl.urbanowicz.rabbitmqpubspringboot;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherMQ {

    @Autowired
    private RabbitTemplate _rabbitTemplate;

    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam String message) {
        _rabbitTemplate.convertAndSend("testowa", message);
        return "sent";
    }
}
