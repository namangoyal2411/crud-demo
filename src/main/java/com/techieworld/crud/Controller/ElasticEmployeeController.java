package com.techieworld.crud.Controller;

import com.techieworld.crud.dto.EmployeeTO;
import com.techieworld.crud.model.Employee;
import com.techieworld.crud.service.ElasticEmployeeService;
import com.techieworld.crud.service.EmployeeService;
import com.techieworld.crud.service.MongoEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/elastic/emp")
public class ElasticEmployeeController {
    @Autowired
    private ElasticEmployeeService elasticEmployeeService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createEmployee(@RequestBody EmployeeTO emp) {
        return elasticEmployeeService.createEmployee(emp);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployee(@PathVariable String id) {
        return elasticEmployeeService.getEmployee(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteEmployee(@PathVariable String id) {
        return elasticEmployeeService.deleteEmployee(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateEmployee(@PathVariable String id, @RequestBody EmployeeTO emp) {
        return elasticEmployeeService.updateEmployee(emp);
    }
}
