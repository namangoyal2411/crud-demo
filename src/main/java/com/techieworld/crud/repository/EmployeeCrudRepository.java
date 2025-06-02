package com.techieworld.crud.repository;

import com.techieworld.crud.dto.EmployeeDTO;
import com.techieworld.crud.model.Employee;

public interface EmployeeCrudRepository {
    Employee getEmployee(String employeeId);

    Employee createEmployee(EmployeeDTO employeeDTO);

    Employee updateEmployee(EmployeeDTO employeeDTO);

    boolean deleteEmployee(String employeeId);
}
