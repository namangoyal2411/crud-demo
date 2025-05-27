package com.techieworld.crud.Controller;

import com.techieworld.crud.dto.EmployeeTO;
import com.techieworld.crud.model.Employee;
import com.techieworld.crud.service.EmployeeService;
import com.techieworld.crud.service.MongoEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mongo/emp")
public class MongoEmployeeController {
    @Autowired
    private MongoEmployeeService mongoemployeeService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createEmployee(@RequestBody EmployeeTO emp){   //accepts JSON input
        return mongoemployeeService.createEmployee(emp);
    }
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployee(@PathVariable String id ){
        return mongoemployeeService.getEmployee(id);

    }
    @GetMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteEmployee(@PathVariable String id){
        return mongoemployeeService.deleteEmployee(id);

    }
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateEmployee(@PathVariable String id, @RequestBody EmployeeTO emp ){
        return mongoemployeeService.updateEmployee(emp);
    }
}
