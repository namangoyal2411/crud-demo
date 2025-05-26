package com.techieworld.crud.service;

import com.techieworld.crud.dto.EmployeeTO;
import com.techieworld.crud.model.Employee;
import com.techieworld.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public String createEmployee(EmployeeTO employeeTO){
        try {
            Employee emp = Employee.builder()
                    .empName(employeeTO.getEmpName())
                    .salary(employeeTO.getSalary())
                    .loction(employeeTO.getLoction()) // corrected spelling
                    .build();

            employeeRepository.save(emp);
        } catch (Exception e) {
        e.printStackTrace();
        }

        return "Employee Created Succesfully";
    }
    public List<Employee> getEmployee(){
        List<Employee> empList= new ArrayList<>();
        try {
         empList = employeeRepository.findAll();
     } catch (Exception e) {

     }
     return empList ;
    }

    public String deleteEmployee(String id ) {
    try {
     employeeRepository.deleteById(id);
    } catch (Exception e) {

    }
    return "Employee deleted Succesfully";
    }

    public String updateEmployee(EmployeeTO emp) {
        try{
            Employee employee = Employee.builder()
                    .id (emp.getId())
                    .empName(emp.getEmpName())
                    .salary(emp.getSalary())
                    .loction(emp.getLoction()) // corrected spelling
                    .build();
            employeeRepository.save (employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Update Succesfully";
    }
}
