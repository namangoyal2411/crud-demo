package com.techieworld.crud.repository;

import com.techieworld.crud.RepositoryInterface.DriverRepositoryInterface;
import com.techieworld.crud.RepositoryInterface.EmployeeRepositoryInterface;
import com.techieworld.crud.dto.EmployeeDTO;
import com.techieworld.crud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public class MongoEmployeeRepository implements EmployeeCrudRepository {

    @Autowired
    private EmployeeRepositoryInterface mongoRepo;
    @Override
    public Employee getEmployee(String employeeId) {
        Optional<Employee> optionalEmployee = mongoRepo.findById(employeeId);
        return optionalEmployee.orElse(null);
    }

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = mapToEmployee(employeeDTO);
        return mongoRepo.save(employee);
    }

    @Override
    public Employee updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = mapToEmployee(employeeDTO);
        return mongoRepo.save(employee);
    }

    @Override
    public boolean deleteEmployee(String employeeId) {
        if (mongoRepo.existsById(employeeId)) {
            mongoRepo.deleteById(employeeId);
            return true;
        }
        return false;
    }

    private Employee mapToEmployee(EmployeeDTO dto) {
        return Employee.builder()
                .id(dto.getId())
                .empName(dto.getEmpName())
                .loction(dto.getLoction())
                .salary(dto.getSalary() != null ? dto.getSalary() : BigDecimal.ZERO)
                .build();
    }
}
