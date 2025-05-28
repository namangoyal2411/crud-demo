package com.techieworld.crud.service;

import com.techieworld.crud.dto.EmployeeTO;
import com.techieworld.crud.model.Employee;
import com.techieworld.crud.repository.MongoEmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MongoEmployeeServiceTest {
    @Mock
    private MongoEmployeeRepository mongoEmployeeRepository;
    @InjectMocks
    private MongoEmployeeService mongoEmployeeService;
    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testCreateEmployee() {
        EmployeeTO employeeTO = EmployeeTO.builder()
                .id("123")
                .empName("John")
                .loction("Delhi")
                .salary(BigDecimal.valueOf(50000))
                .build();

        Employee mockEmployee = Employee.builder()
                .id("123")
                .empName("John")
                .loction("Delhi")
                .salary(BigDecimal.valueOf(50000))
                .build();
        when(mongoEmployeeRepository.createEmployee(employeeTO)).thenReturn(mockEmployee);

        Employee result = mongoEmployeeService.createEmployee(employeeTO);

        assertEquals(mockEmployee, result);
        verify(mongoEmployeeRepository, times(1)).createEmployee(employeeTO);
    }
    @Test
    void testGetEmployee(){
        Employee employee = Employee.builder().id("abc").empName("Naman").loction("Gurugram").salary(BigDecimal.valueOf(50000))
                .build();
        when (mongoEmployeeRepository.getEmployee(employee.getId())).thenReturn(employee);
        Employee result = mongoEmployeeService.getEmployee(employee.getId());
        assertEquals(employee, result);
        verify(mongoEmployeeRepository, times(1)).getEmployee(employee.getId());
    }
    @Test
    void testUpdateEmployee(){
        EmployeeTO MockEmployee= EmployeeTO.builder().id("123").empName("Ashwin").loction("Hyderabd").salary(BigDecimal.valueOf(90000)).build();
        Employee UpdatedMockEmployee = Employee.builder().id("1234").empName("Ashwin").loction("Chennai").salary( BigDecimal.valueOf(100000)).build();
        when (mongoEmployeeRepository.updateEmployee(MockEmployee)).thenReturn(UpdatedMockEmployee);
        Employee test = mongoEmployeeService.updateEmployee(MockEmployee);
        assertEquals(UpdatedMockEmployee,test);
        verify(mongoEmployeeRepository, times(1)).updateEmployee(MockEmployee);
    }
    @Test
    void testDeleteEmployee(){
        Employee MockEmployee = Employee.builder().id("xyz").empName("Sanath").loction("Mumbai").salary(BigDecimal.valueOf(500000)).build();
       // when(mongoEmployeeRepository.deleteEmployee("xyz")).thenReturn(true);
        when(mongoEmployeeRepository.deleteEmployee("abc")).thenReturn(false);
        String test = mongoEmployeeService.deleteEmployee(MockEmployee.getId());
        boolean ans ;
        if (test=="true")
            ans = true ;
        else ans = false ;
        assertEquals(ans,false);
        verify(mongoEmployeeRepository, times(1)).deleteEmployee(MockEmployee.getId());
    }
}
