package com.techieworld.crud.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techieworld.crud.dto.EmployeeDTO;
import com.techieworld.crud.repository.MongoEmployeeRepository;
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
            EmployeeDTO employeeDTO = objectMapper.readValue(message, EmployeeDTO.class);
            mongoRepository.createEmployee(employeeDTO);
            System.out.println("Successfully Saved" + employeeDTO);
        } catch (Exception e) {
            System.err.println("Failed to save " + e.getMessage());
        }
    }
}
