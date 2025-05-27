package com.techieworld.crud.service;

import com.techieworld.crud.Controller.EmployeeController;
import com.techieworld.crud.dto.EmployeeTO;
import com.techieworld.crud.model.Employee;
import com.techieworld.crud.repository.ElasticEmployeeRepository;
import com.techieworld.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
// need to basically create 2 classes in my interface employeecrud repository these 2 classes wll take my data and will
// save it to mongodb and es database
@Service
public class ElasticEmployeeService{
    @Autowired
    private final ElasticEmployeeRepository elasticrepo;

    @Autowired
    public ElasticEmployeeService( ElasticEmployeeRepository elasticrepo) {
        this.elasticrepo = elasticrepo;
    }

    public String createEmployee(EmployeeTO employeeTO){
        Employee employee =elasticrepo.createEmployee(employeeTO);

        return employee.getId();

    }
    public Employee getEmployee(String id ){
        Employee emp= elasticrepo.getEmployee(id);
        return emp ;
    }

    public String deleteEmployee(String id ) {
        elasticrepo.deleteEmployee(id);
        return "true";
    }

    public String updateEmployee(EmployeeTO emp) {
        elasticrepo.updateEmployee(emp);
        return "Update Succesfully";
    }
}
