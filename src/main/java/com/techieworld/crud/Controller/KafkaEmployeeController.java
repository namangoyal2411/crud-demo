package com.techieworld.crud.Controller;

import com.techieworld.crud.Kafka.EmployeeProducer;
import com.techieworld.crud.dto.EmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/api/kafka/emp/insert")
    public class KafkaEmployeeController {

        @Autowired
        private EmployeeProducer kafkaProducer;

        @PostMapping
        public ResponseEntity<String> sendEmployeeToKafka(@RequestBody EmployeeTO employeeTO) {
            kafkaProducer.sendToKafka(employeeTO);
            return ResponseEntity.ok("Employee data sent to Kafka.");
        }


}
