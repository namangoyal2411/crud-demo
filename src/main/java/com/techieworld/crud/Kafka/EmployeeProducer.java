package com.techieworld.crud.Kafka;

import com.techieworld.crud.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

// This will publish my EmployeeTO object to Kafka Topic
@Service
public class EmployeeProducer {
    private static final String topic ="Employee";
    @Autowired
    private KafkaTemplate<String, EmployeeDTO> kafkaTemplate;
    public void sendToKafka(EmployeeDTO employeeDTO) {
        kafkaTemplate.send(topic, employeeDTO.getId(), employeeDTO);
        System.out.println("Published to Kafka: " + employeeDTO);
    }
}
