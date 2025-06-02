package com.techieworld.crud.service;

import com.techieworld.crud.dto.EmployeeDTO;
import com.techieworld.crud.model.Employee;
import com.techieworld.crud.repository.ElasticEmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ElasticEmployeeServiceTest {

    @Mock
    private ElasticEmployeeRepository elasticEmployeeRepository;

    @InjectMocks
    private ElasticEmployeeService elasticEmployeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // initialize @Mock and @InjectMocks
    }

    @Test
    void testCreateEmployee() {
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
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
        when(elasticEmployeeRepository.createEmployee(employeeDTO)).thenReturn(mockEmployee);

        Employee result = elasticEmployeeService.createEmployee(employeeDTO);

        assertEquals(mockEmployee, result);
        verify(elasticEmployeeRepository, times(1)).createEmployee(employeeDTO);
    }
    @Test
    void testGetEmployee(){
        Employee employee = Employee.builder()
                .id("abc").empName("Naman").loction("Delhi").salary(BigDecimal.valueOf(150000)).build();
        when(elasticEmployeeRepository.getEmployee(employee.getId())).thenReturn(employee);
        Employee test = elasticEmployeeService.getEmployee(employee.getId());
        assertEquals(employee,test);
        verify(elasticEmployeeRepository, times(1)).getEmployee(employee.getId());
    }
    @Test
    void testUpdateEmployee(){
      EmployeeDTO MockEmployee= EmployeeDTO.builder().id("123").empName("Ashwin").loction("Hyderabd").salary(BigDecimal.valueOf(90000)).build();
      Employee UpdatedMockEmployee = Employee.builder().id("1234").empName("Ashwin").loction("Chennai").salary( BigDecimal.valueOf(100000)).build();
      when (elasticEmployeeRepository.updateEmployee(MockEmployee)).thenReturn(UpdatedMockEmployee);
      Employee test = elasticEmployeeService.updateEmployee(MockEmployee);
      assertEquals(UpdatedMockEmployee,test);
      verify(elasticEmployeeRepository, times(1)).updateEmployee(MockEmployee);
    }
    @Test
    void testDeleteEmployee(){
        Employee MockEmployee = Employee.builder().id("xyz").empName("Sanath").loction("Mumbai").salary(BigDecimal.valueOf(500000)).build();
        when(elasticEmployeeRepository.deleteEmployee("xyz")).thenReturn(true);
        String test = elasticEmployeeService.deleteEmployee(MockEmployee.getId());
        boolean ans ;
        if (test=="true")
            ans = true ;
        else ans = false ;
        assertEquals(ans,true);
        verify(elasticEmployeeRepository, times(1)).deleteEmployee(MockEmployee.getId());
    }
}
