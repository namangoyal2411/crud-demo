package com.techieworld.crud.service;

import com.techieworld.crud.dto.EmployeeDTO;
import com.techieworld.crud.model.Employee;
import com.techieworld.crud.repository.ElasticEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElasticEmployeeService{
    @Autowired
    private final ElasticEmployeeRepository elasticrepo;

    @Autowired
    public ElasticEmployeeService( ElasticEmployeeRepository elasticrepo) {
        this.elasticrepo = elasticrepo;
    }

    public Employee createEmployee(EmployeeDTO employeeDTO){
        Employee employee =elasticrepo.createEmployee(employeeDTO);

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

    public Employee updateEmployee(EmployeeDTO emp) {
        Employee employee= elasticrepo.updateEmployee(emp);
        return employee;
    }
}
