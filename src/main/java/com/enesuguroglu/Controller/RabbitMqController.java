package com.enesuguroglu.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.enesuguroglu.Model.Notification;
import com.enesuguroglu.Producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqController {

    @Autowired
    NotificationProducer notificationProducer;

    @PostMapping("/v1/sendnotification")
    public ResponseEntity<Notification> postNotification(@RequestBody Notification notification) throws JsonProcessingException{

        notificationProducer.sendToQueue(notification);

        return ResponseEntity.status(HttpStatus.CREATED).body(notification);
    }



}
