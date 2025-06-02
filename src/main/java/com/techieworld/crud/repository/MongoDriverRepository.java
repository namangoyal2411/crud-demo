package com.techieworld.crud.repository;

import com.techieworld.crud.Controller.MongoDriverController;
import com.techieworld.crud.RepositoryInterface.DriverRepositoryInterface;
import com.techieworld.crud.dto.DriverDTO;
import com.techieworld.crud.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MongoDriverRepository {
    @Autowired
    private DriverRepositoryInterface driverRepo;
    public DriverDTO createEmployee(DriverDTO driverDTO) {
        try {
            Driver driver = Driver.builder()
                    .id(driverDTO.getId())
                    .name(driverDTO.getName())
                    .location(driverDTO.getLocation())
                    .vehicle(driverDTO.getVehicle())
                    .build();
             driverRepo.save(driver);
        } catch (Exception e) {
            e.printStackTrace(); // THIS WILL SHOW THE ACTUAL REASON IN TERMINAL
            throw new RuntimeException("Failed to save driver", e);
        }
        return driverDTO;

    }
}
