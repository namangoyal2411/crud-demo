package com.techieworld.crud.repository;

import com.techieworld.crud.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends MongoRepository<Employee,String> {

}
