package com.example.notifications_system.controller;
import java.util.Map;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import com.example.notifications_system.entity.notification;
import com.example.notifications_system.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService service;

    private final SimpMessagingTemplate template;

    public NotificationController(
            NotificationService service,
            SimpMessagingTemplate template) {

        this.service = service;
        this.template = template;
    }

    @PostMapping
    public notification sendNotification(
            @RequestBody Map<String,String> body) {

        String message =
                body.get("message");

        notification notification =
                service.saveNotification(message);

        template.convertAndSend(
                "/topic/notifications",
                notification);

        return notification;
    }
}