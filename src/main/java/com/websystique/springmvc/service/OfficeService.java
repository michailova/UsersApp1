package com.websystique.springmvc.service;


import com.websystique.springmvc.model.Office;
import com.websystique.springmvc.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface OfficeService {
    List<Office> findAllOffices();

    Office findById(int id);


    void saveOffice(Office office);

    void updateOffice(Office office);

    void deleteOfficeById(int id);

//    String saveOffice(Office office);
}

