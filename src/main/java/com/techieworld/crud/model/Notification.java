package com.techieworld.crud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Data
@Builder
@Document(collection="Notification")
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    private String id ;
    private String name ;
    private String status ;
    private String message ;
}
