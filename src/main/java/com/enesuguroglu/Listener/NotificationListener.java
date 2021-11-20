package com.enesuguroglu.Listener;

import com.enesuguroglu.Model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "${rabbit.queue.name}")
    public void handleMessage(Notification notification){
        System.out.println(notification.toString());

    }
}
