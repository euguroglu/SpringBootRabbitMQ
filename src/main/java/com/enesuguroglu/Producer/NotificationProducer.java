package com.enesuguroglu.Producer;

import com.enesuguroglu.Model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {

    @Value("${rabbit.binding.name}")
    private String bindingName;

    @Value("${rabbit.exchange.name}")
    private String exchangeName;

  /*  @PostConstruct
    public void init(){
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("Welcome to rabbitmq producer consumer app");
        notification.setSeen(Boolean.FALSE);

        sendToQueue(notification);
    } */

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToQueue(Notification notification){
        System.out.println("Notification Sent ID: " + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName,bindingName, notification);

    }
}
