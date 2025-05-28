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
@Service
public class ElasticEmployeeService{
    @Autowired
    private final ElasticEmployeeRepository elasticrepo;

    @Autowired
    public ElasticEmployeeService( ElasticEmployeeRepository elasticrepo) {
        this.elasticrepo = elasticrepo;
    }

    public Employee createEmployee(EmployeeTO employeeTO){
        Employee employee =elasticrepo.createEmployee(employeeTO);

        return employee;

    }
    public Employee getEmployee(String id ){
        Employee emp= elasticrepo.getEmployee(id);
        return emp ;
    }

    public String deleteEmployee(String id ) {
        boolean result =elasticrepo.deleteEmployee(id);
        if (result ) {
            return "true";
        }
        return "false";
    }

    public Employee updateEmployee(EmployeeTO emp) {
        Employee employee= elasticrepo.updateEmployee(emp);
        return employee;
    }
}
