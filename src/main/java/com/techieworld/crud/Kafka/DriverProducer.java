package com.techieworld.crud.Kafka;

import com.techieworld.crud.dto.DriverDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DriverProducer {
    private static final String topic = "Driver_details";
    @Autowired
    private KafkaTemplate<String, DriverDTO> kafkatemplate;
    public  void senddata(DriverDTO driverdto){

        kafkatemplate.send(topic,driverdto.getId(),driverdto);
    }
}
