package com.techieworld.crud.Kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techieworld.crud.dto.DriverDTO;
import com.techieworld.crud.model.Notification;
import com.techieworld.crud.repository.DriverNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DriverNotificationConsumer {
    @Autowired
    private DriverNotificationRepository driverNotificationRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @KafkaListener(topics="Driver_details",groupId = "Notification")
    public void consume (String message){
        try {
            DriverDTO driverDTO=  objectMapper.readValue(message,DriverDTO.class);
            Notification notification = Notification.builder().
                                   name(driverDTO.getName()).
                                   id(driverDTO.getId()).
                                   message("Successfully Registered").
                                   status("Sent").build();
            driverNotificationRepository.save(notification);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
