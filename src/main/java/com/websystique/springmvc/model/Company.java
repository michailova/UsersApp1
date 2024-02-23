package com.websystique.springmvc.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Company {

    private String name;
    private String address;

    public Company(){
        name = "Unknown";
        address = "Unknown";
    }
}
