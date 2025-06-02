package com.techieworld.crud.Kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techieworld.crud.dto.DriverDTO;
import com.techieworld.crud.model.Employee;
import com.techieworld.crud.repository.MongoDriverRepository;
import com.techieworld.crud.repository.MongoEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MongoDriverConsumer {
    @Autowired
    private MongoDriverRepository mongoDriverRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @KafkaListener(topics= "Driver_details",groupId="Driver")
       public void consume (String message){
        try{
             DriverDTO driverDTO= objectMapper.readValue(message,DriverDTO.class);
             mongoDriverRepository.createEmployee(driverDTO);
            System.out.println("Successfully Saved" + driverDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
       }
}
