package com.techieworld.crud.service;

import com.techieworld.crud.Kafka.DriverProducer;
import com.techieworld.crud.dto.DriverDTO;
import com.techieworld.crud.repository.MongoDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoDriverService {
    @Autowired
    private DriverProducer driverProducer;
    @Autowired
    private MongoDriverRepository mongoDriverRepository;

    public DriverDTO createDriver(DriverDTO driverDTO, boolean kafkaEnabled) {
        if (kafkaEnabled) {
            driverProducer.senddata(driverDTO);
        } else mongoDriverRepository.createEmployee(driverDTO);
        return driverDTO;
    }
}
