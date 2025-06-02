package com.techieworld.crud.model;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection ="Driver")
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    private String id ;
    private String name;
    private String location;
    private String vehicle;

}
