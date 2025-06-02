package com.techieworld.crud.RepositoryInterface;

import com.techieworld.crud.model.Employee;
import com.techieworld.crud.repository.MongoEmployeeRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryInterface extends MongoRepository<Employee,String> {

}
