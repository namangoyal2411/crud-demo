package com.techieworld.crud.Controller;

import com.techieworld.crud.dto.EmployeeDTO;
import com.techieworld.crud.model.Employee;
import com.techieworld.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createEmployee(@RequestBody EmployeeDTO emp){   //accepts JSON input
return employeeService.createEmployee(emp);
    }
    @GetMapping("/get/employee")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployee(@RequestParam String id ){
     return employeeService.getEmployee(id);

    }
    @GetMapping("/delete/employee")
    @ResponseStatus(HttpStatus.OK)
    public String deleteEmployee(@RequestParam String id){
        return employeeService.deleteEmployee(id);

    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateEmployee(@RequestBody EmployeeDTO emp){
        return employeeService.updateEmployee(emp);
    }
}
