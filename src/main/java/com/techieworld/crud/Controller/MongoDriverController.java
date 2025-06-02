package com.techieworld.crud.Controller;

import com.techieworld.crud.dto.DriverDTO;
import com.techieworld.crud.service.MongoDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/driver")
public class MongoDriverController {
    @Autowired
    private MongoDriverService mongoDriverService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public DriverDTO getDriver(@RequestBody DriverDTO driverDTO, @RequestParam(defaultValue = "false") boolean kafkaenabled){
           mongoDriverService.createDriver(driverDTO, kafkaenabled);
        return driverDTO;
    }
}
