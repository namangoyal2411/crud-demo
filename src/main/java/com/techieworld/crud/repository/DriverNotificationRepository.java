package com.techieworld.crud.repository;

import com.techieworld.crud.RepositoryInterface.NotificationRepositoryInterface;
import com.techieworld.crud.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DriverNotificationRepository {
    @Autowired
    private NotificationRepositoryInterface notificationRepo;
    public void save  (Notification notification){
        notificationRepo.save(notification);
    }
}
