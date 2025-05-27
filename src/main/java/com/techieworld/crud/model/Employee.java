package com.techieworld.crud.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document(collection = "employee")
@Data
@Builder

public class Employee {
    @Id
    private String id ;
    @Field(name = "employee_name")
    @JsonProperty("employee_name")
    private String empName ;
    private String loction;
    private BigDecimal salary;
}
