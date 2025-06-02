package com.techieworld.crud.service;

import com.techieworld.crud.Kafka.EmployeeProducer;
import com.techieworld.crud.dto.EmployeeDTO;
import com.techieworld.crud.model.Employee;
import com.techieworld.crud.repository.MongoEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// need to basically create 2 classes in my interface employeecrud repository these 2 classes wll take my data and will
// save it to mongodb and es database
@Service
public class MongoEmployeeService{
    @Autowired
    private final MongoEmployeeRepository mongorepo;
    @Autowired
    private EmployeeProducer kafkaProducer;
    @Autowired
    public MongoEmployeeService(MongoEmployeeRepository mongorepo) {
        this.mongorepo=mongorepo;
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO, boolean kafkaEnabled){
        if (kafkaEnabled){
            kafkaProducer.sendToKafka(employeeDTO);
        }
        else mongorepo.createEmployee(employeeDTO);

        return employeeDTO;

    }
    public Employee getEmployee(String id ){
        Employee emp = mongorepo.getEmployee(id);
        return emp ;
    }

    public String deleteEmployee(String id ) {
       boolean result= mongorepo.deleteEmployee(id);
        if (result ) {
            return "true";
        }
        else return "false";
    }

    public Employee updateEmployee(EmployeeDTO emp) {
        Employee employee = mongorepo.updateEmployee(emp);
        return employee;
    }
}
