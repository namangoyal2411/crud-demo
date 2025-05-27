package com.techieworld.crud.repository;

import com.techieworld.crud.dto.EmployeeTO;
import com.techieworld.crud.model.Employee;

public interface EmployeeCrudRepository {
    Employee getEmployee(String employeeId);

    Employee createEmployee(EmployeeTO employeeTO);

    Employee updateEmployee(EmployeeTO employeeTO);

    boolean deleteEmployee(String employeeId);
}
