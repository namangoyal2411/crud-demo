package com.techieworld.crud.Kafka;

import com.techieworld.crud.dto.EmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

// This will publish my EmployeeTO object to Kafka Topic
@Service
public class EmployeeProducer {
    private static final String topic ="Employee";
    @Autowired
    private KafkaTemplate<String, EmployeeTO> kafkaTemplate;
    public void sendToKafka(EmployeeTO employeeTO) {
        kafkaTemplate.send(topic, employeeTO.getId(), employeeTO);
        System.out.println("Published to Kafka: " + employeeTO);
    }
}
