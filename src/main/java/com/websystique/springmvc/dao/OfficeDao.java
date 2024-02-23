package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Office;


import java.util.List;


public interface OfficeDao {

    List<Office> findAllOffices();

    Office findById(int id);

    void save(Office office);

    void update(Office office);

    void deleteById(int id);

}
