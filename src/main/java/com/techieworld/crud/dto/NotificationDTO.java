package com.techieworld.crud.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationDTO {
    private String name ;
    private String message ;

}
