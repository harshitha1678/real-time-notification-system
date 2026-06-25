package com.example.notifications_system.service;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.notifications_system.entity.notification;
import com.example.notifications_system.repository.NotificationRepository;

@Service
public class NotificationService {
 private final NotificationRepository repository;

    public NotificationService(
            NotificationRepository repository) {

        this.repository = repository;
    }

    public notification saveNotification(
            String message) {

        notification n = new notification();

        n.setMessage(message);
        n.setReadStatus(false);
        n.setCreatedAt(LocalDateTime.now());

        return repository.save(n);
    }
}