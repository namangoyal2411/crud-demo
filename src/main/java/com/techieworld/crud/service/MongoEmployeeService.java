package com.techieworld.crud.service;

import com.techieworld.crud.Controller.EmployeeController;
import com.techieworld.crud.dto.EmployeeTO;
import com.techieworld.crud.model.Employee;
import com.techieworld.crud.repository.EmployeeRepository;
import com.techieworld.crud.repository.MongoEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
// need to basically create 2 classes in my interface employeecrud repository these 2 classes wll take my data and will
// save it to mongodb and es database
@Service
public class MongoEmployeeService{
    @Autowired
    private final MongoEmployeeRepository mongorepo;

    @Autowired
    public MongoEmployeeService(MongoEmployeeRepository mongorepo) {
        this.mongorepo=mongorepo;
    }

    public String createEmployee(EmployeeTO employeeTO){
        Employee employee = mongorepo.createEmployee(employeeTO);

        return employee.getId();

    }
    public Employee getEmployee(String id ){
        Employee emp = mongorepo.getEmployee(id);
        return emp ;
    }

    public String deleteEmployee(String id ) {
        mongorepo.deleteEmployee(id);
        return "true";
    }

    public String updateEmployee(EmployeeTO emp) {
        mongorepo.updateEmployee(emp);
        return "Update Succesfully";
    }
}
