package com.techieworld.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {
   @Id
   private String id;
   private String name;
   private String location;
   private String vehicle;
}
