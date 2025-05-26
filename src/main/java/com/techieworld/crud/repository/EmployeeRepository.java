package com.techieworld.crud.repository;

import com.techieworld.crud.dto.EmployeeTO;
import com.techieworld.crud.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository

public interface EmployeeRepository extends MongoRepository<Employee,String> {

}
