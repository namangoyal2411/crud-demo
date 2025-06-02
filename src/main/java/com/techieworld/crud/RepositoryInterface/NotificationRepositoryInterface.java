package com.techieworld.crud.RepositoryInterface;

import com.techieworld.crud.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepositoryInterface extends MongoRepository<Notification,String> {
}
