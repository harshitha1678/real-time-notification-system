package com.example.notifications_system.repository;
import com.example.notifications_system.entity.notification;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<notification, Long> {

}
