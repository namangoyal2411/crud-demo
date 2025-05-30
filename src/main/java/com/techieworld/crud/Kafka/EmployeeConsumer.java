package com.techieworld.crud.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techieworld.crud.dto.EmployeeTO;
import com.techieworld.crud.model.Employee;
import com.techieworld.crud.repository.MongoEmployeeRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeConsumer {

    @Autowired
    private MongoEmployeeRepository mongoRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "Employee", groupId = "employee-group")
    public void consume(String message) {
        try {
            EmployeeTO employeeTO = objectMapper.readValue(message, EmployeeTO.class);
            mongoRepository.createEmployee(employeeTO);
            System.out.println("Successfully Saved" + employeeTO);
        } catch (Exception e) {
            System.err.println("Failed to save " + e.getMessage());
        }
    }
}
