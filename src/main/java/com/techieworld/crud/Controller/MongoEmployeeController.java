package com.techieworld.crud.Controller;

import com.techieworld.crud.dto.EmployeeDTO;
import com.techieworld.crud.model.Employee;
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
    public EmployeeDTO createmployee(@RequestBody EmployeeDTO emp, @RequestParam(defaultValue = "false") boolean kafkaEnabled){   //accepts JSON input
        return mongoemployeeService.createEmployee(emp,kafkaEnabled);
    }
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployee(@PathVariable String id ){
        return mongoemployeeService.getEmployee(id);

    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteEmployee(@PathVariable String id){
        return mongoemployeeService.deleteEmployee(id);

    }
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee updateEmployee(@PathVariable String id, @RequestBody EmployeeDTO emp ){
        return mongoemployeeService.updateEmployee(emp);
    }
}
