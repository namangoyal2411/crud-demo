package com.techieworld.crud.service;

import com.techieworld.crud.dto.EmployeeDTO;
import com.techieworld.crud.model.Employee;
import com.techieworld.crud.repository.ElasticEmployeeRepository;
import com.techieworld.crud.repository.MongoEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// need to basically create 2 classes in my interface employeecrud repository these 2 classes wll take my data and will
// save it to mongodb and es database
@Service
public class EmployeeService{
    @Autowired
    private final MongoEmployeeRepository mongorepo;
    private final ElasticEmployeeRepository elasticrepo;

    @Autowired
    public EmployeeService(MongoEmployeeRepository mongorepo, ElasticEmployeeRepository elasticrepo) {
        this.mongorepo=mongorepo;
        this.elasticrepo = elasticrepo;
    }

    public String createEmployee(EmployeeDTO employeeDTO){
       Employee employee = mongorepo.createEmployee(employeeDTO);
      elasticrepo.createEmployee(employeeDTO);

        return employee.getId();

    }
    public Employee getEmployee(String id ){
      Employee emp = mongorepo.getEmployee(id);
        Employee emp1 = elasticrepo.getEmployee(id);
      return emp ;
    }

    public String deleteEmployee(String id ) {
     mongorepo.deleteEmployee(id);
    elasticrepo.deleteEmployee(id);
     return "true";
    }

    public String updateEmployee(EmployeeDTO emp) {
        mongorepo.updateEmployee(emp);
        elasticrepo.updateEmployee(emp);
        return "Update Succesfully";
    }
}
